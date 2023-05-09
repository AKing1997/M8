package com.example.tresenralla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;

public class Online extends Fragment {
    private ImageButton ob3;
    private ImageButton ob4;
    private ImageButton ob2;
    private ImageButton ob1;
    private ImageButton ob5;
    private ImageButton ob6;
    private ImageButton ob7;
    private ImageButton ob8;
    private ImageButton ob9;
    private RadioButton x;
    private RadioButton o;
    private String selected;
    private boolean selectedBool;
   // private ClientThread clientThread;
    private MaterialToolbar materialToolbarOn;

    public Online(String ip, String port) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online, container, false);
        materialToolbarOn = view.findViewById(R.id.materialToolbarOn);
        materialToolbarOn.setTitle("Online");
        ob3 = view.findViewById(R.id.ob3);
        ob4 = view.findViewById(R.id.ob4);
        ob2 = view.findViewById(R.id.ob2);
        ob1 = view.findViewById(R.id.ob1);
        ob5 = view.findViewById(R.id.ob5);
        ob6 = view.findViewById(R.id.ob6);
        ob7 = view.findViewById(R.id.ob7);
        ob8 = view.findViewById(R.id.ob8);
        ob9 = view.findViewById(R.id.ob9);
        x = view.findViewById(R.id.x);
        o = view.findViewById(R.id.o);


        return view;
    }
}