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
import android.widget.TextView;
import android.widget.Toast;

import com.example.biblioteca_java.Connexion.ConnexionFirebase;
import com.example.biblioteca_java.Connexion.Insert;
import com.example.biblioteca_java.Connexion.Modificar;
import com.example.biblioteca_java.Data.Libro;
import com.example.biblioteca_java.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Modifica#} factory method to
 * create an instance of this fragment.
 */
public class Modifica extends Fragment {
    private Libro libro;
    public Modifica(Libro libro) {
        this.libro = libro;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modifica, container, false);

        TextView id  = view.findViewById(R.id.idModifyLibro);
        EditText titulo = view.findViewById(R.id.tituloAddLibro);
        EditText fecha = view.findViewById(R.id.dateAddLibro);
        EditText autor = view.findViewById(R.id.autorAddLibro);
        EditText editorial = view.findViewById(R.id.editorialAddLibro);
        EditText tematica  = view.findViewById(R.id.tematicaAddLibro);
        ImageButton modificarButton = view.findViewById(R.id.addButton);
        id.setText(String.valueOf(libro.getId()));
        titulo.setText(libro.getTitulo());
        autor.setText(libro.getAutor());
        modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnexionFirebase connect = new ConnexionFirebase();
                connect.modificar(new Libro(libro.getId(), titulo.getText().toString(),autor.getText().toString()));
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Biblioteca()).commit();
                /*Modificar insertar = new Modificar();
                insertar.execute(new Libro(libro.getId(), titulo.getText().toString(),autor.getText().toString(),editorial.getText().toString(),fecha.getText().toString(),tematica.getText().toString()));
            */}
        });
        return view;
    }
}

