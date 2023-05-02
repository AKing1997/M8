package com.example.uf3p3;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private MainActivity mainActivity;
    private String serverIpAddress;
    private int serverPort;

    public ClientThread(MainActivity activity, String ipAddress, int port) {
        mainActivity = activity;
        serverIpAddress = ipAddress;
        serverPort = port;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(serverIpAddress, serverPort);
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainActivity.onConnect();
                }
            });
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    final String message = (String) inputStream.readObject();
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mainActivity.onMessageReceived(message);
                        }
                    });
                } catch (final IOException | ClassNotFoundException e) {
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mainActivity.onConnectionError();
                        }
                    });
                    break;
                }
            }
        } catch (final IOException e) {
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainActivity.onConnectionError();
                }
            });
        }
    }

    public void sendMessage(final String message) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    outputStream.writeObject(message);
                    outputStream.flush();
                } catch (final IOException e) {
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mainActivity.onConnectionError();
                        }
                    });
                }
            }
        });
    }

    public void disconnect() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (final IOException e) {
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainActivity.onConnectionError();
                }
            });
        }
    }
}
