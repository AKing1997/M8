package com.example.biblioteca_java.Connexion;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.biblioteca_java.Data.Libro;
import com.example.biblioteca_java.Fragments.Biblioteca;
import com.example.biblioteca_java.Fragments.DetailBook;
import com.example.biblioteca_java.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Delete extends AsyncTask<String, String, Void> {
    private String urlString = "http://10.0.2.2:8080" ;
    private URL url;
    private View view;

    private HttpURLConnection conexion;
    /**
     * @param libro The parameters of the task.
     * @return null
     */
    @Override
    protected Void doInBackground(String... libro) {
        try {

            this.url = new URL(this.urlString+"/borrado/"+libro[0]);

            this.conexion = (HttpURLConnection) this.url.openConnection();
            this.conexion.setRequestMethod("DELETE");
            //this.conexion.setRequestProperty("Content-Type", "application/json");
            this.conexion.connect();
            if (this.conexion.getResponseCode() == HttpURLConnection.HTTP_OK) { //success
                Log.i("Modificar", "Antes de comit Modificar2");

                //Toast.makeText(this.view.getContext(), "Se ha modificado correctamente", Toast.LENGTH_LONG).show();
            } else {
                Log.i("Modificar", "Errror Antes de comit Modificar2");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
