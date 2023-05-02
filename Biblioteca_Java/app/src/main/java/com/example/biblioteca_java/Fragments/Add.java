package com.example.biblioteca_java.Fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.biblioteca_java.Connexion.ConnexionFirebase;
import com.example.biblioteca_java.Connexion.Insert;
import com.example.biblioteca_java.Data.Libro;
import com.example.biblioteca_java.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add#} factory method to
 * create an instance of this fragment.
 */
public class Add extends Fragment {
    private DatabaseReference myDB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        EditText titulo = view.findViewById(R.id.tituloAddLibro);
        EditText autor = view.findViewById(R.id.autorAddLibro);
        ImageButton modificarButton = view.findViewById(R.id.addButton);
        modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnexionFirebase connect = new ConnexionFirebase();
                connect.writeBook(new Libro(UUID.randomUUID().toString(), titulo.getText().toString(),autor.getText().toString()));
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Biblioteca()).commit();
            }
        });
        return view;
    }
}