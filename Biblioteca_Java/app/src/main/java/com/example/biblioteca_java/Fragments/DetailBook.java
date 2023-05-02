package com.example.biblioteca_java.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biblioteca_java.Connexion.ConnexionFirebase;
import com.example.biblioteca_java.Connexion.Delete;
import com.example.biblioteca_java.Data.Libro;
import com.example.biblioteca_java.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailBook#} factory method to
 * create an instance of this fragment.
 */
public class DetailBook extends Fragment {
    private Libro libro;
    public DetailBook(Libro libro) {
        this.libro = libro;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_detail_book, container, false);
        TextView tituloLibro  = view.findViewById(R.id.tituloLibro);
        TextView autorLibro  = view.findViewById(R.id.autorLibro);
        ImageButton delete = view.findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnexionFirebase connect = new ConnexionFirebase();
                connect.eliminar(libro.getId());
                Toast.makeText(view.getContext(),"Eliminado", Toast.LENGTH_SHORT ).show();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Biblioteca()).commit();
            }
        });
        tituloLibro.setText("Titulo: "+libro.getTitulo());
        autorLibro.setText("Autor: "+libro.getAutor());

        return  view;
    }
}