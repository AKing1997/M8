package com.example.tresenralla;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import java.lang.Integer;
import java.util.ArrayList;

public class OffLine extends Fragment {
    private String ip;
    private String port;
    private Button resetBtn;
    private Button homeBtn;
    private static Toast toast;
    private static ConstraintLayout ganador;
    private static int SERVERPORT;
    private static String ADDRESS;
    private static boolean player = true;

    private String[] tree = new String[9];

    private ArrayList<ImageButton> btn = new ArrayList<>();
    private RadioButton x;
    private RadioButton o;

    private static final int red = R.drawable.button_background_red;
    private static final int blue = R.drawable.button_background;
    private static final int X = R.drawable.x_24;
    private static final int O = R.drawable.o_24;
    private static final int transp = R.drawable.transp;

    private boolean selected = false;
    private boolean selectedBool = false;
    private MaterialToolbar materialToolbarOff;

    public OffLine(String ip, String port) {
        SERVERPORT = Integer.parseInt(port);
        ADDRESS = ip;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_off_line, container, false);
        materialToolbarOff = view.findViewById(R.id.materialToolbarOff);
        ganador = view.findViewById(R.id.sccoreConteiner);
        resetBtn = view.findViewById(R.id.resetBtn);
        homeBtn = view.findViewById(R.id.homeBtn);
        toast = Toast.makeText(view.getContext(), "Connected", Toast.LENGTH_SHORT);
        toast.show();
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redrige = new Intent(view.getContext(), MainActivity.class);
                startActivity(redrige);
            }
        });
        materialToolbarOff.setTitle("OffLine");
       /* SERVERPORT = Integer.parseInt(port);
        ADDRESS = ip;*/
        RadioGroup playGBtn = view.findViewById(R.id.playGBtn);
        for (int i = 1; i <= 9; i++) {
            int id = getResources().getIdentifier("b" + i, "id", requireContext().getPackageName());
            ImageButton imageButton = view.findViewById(id);
            btn.add(imageButton);
        }
        x = view.findViewById(R.id.x);
        o = view.findViewById(R.id.o);

        if (!selectedBool) {
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected = false;
                    selectedBool = true;
                    setOnlistner();
                    disableRBtn();
                }
            });
            o.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected = true;
                    selectedBool = true;
                    setOnlistner();
                    disableRBtn();
                }
            });
        }
        return view;
    }

    public void disableRBtn() {
        x.setClickable(false);
        o.setClickable(false);
    }

    public void setOnlistner() {
        for (int index = 0; index < btn.size(); index++) {
            final int buttonIndex = index;
            ImageButton button = btn.get(index);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (player) {
                        player = false;
                        cambiarImagen(button, selected ? O : X, blue);
                        tree[buttonIndex] = "1";
                        /*MyATaskCliente myATaskYW = new MyATaskCliente();
                        myATaskYW.execute(treeToString());*/
                    }
                }
            });
        }
    }

    private String treeToString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
            temp.append(tree[i]);
            if (i < tree.length - 1) {
                temp.append(",");
            }
        }
        return temp.toString();
    }

    public void cambiarImagen(ImageButton img, int image, int backG) {
        img.setBackgroundResource(backG);
        img.setImageResource(image);
    }

    public void resetGame() {
        for (int i = 0; i < tree.length; i++) {
            tree[i] = "-1";
        }
        for (ImageButton b : btn) {
            cambiarImagen(b, transp, R.drawable.border);
        }
    }

    public void setPosicion(int x, String selectedOp) {
        if (tree[x] != "-1") {
            return;
        }
        tree[x] = selectedOp;
    }

}