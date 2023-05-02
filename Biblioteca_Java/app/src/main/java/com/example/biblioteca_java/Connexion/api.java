package com.example.biblioteca_java.Connexion;

import com.example.biblioteca_java.Data.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {
    @GET("/libros")
    Call<List<Libro>> getLibros();
}
