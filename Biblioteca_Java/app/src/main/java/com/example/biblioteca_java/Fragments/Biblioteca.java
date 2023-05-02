package com.example.biblioteca_java.Fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.biblioteca_java.Connexion.ConnBiblioteca;
import com.example.biblioteca_java.Connexion.ConnexionFirebase;
import com.example.biblioteca_java.Connexion.api;
import com.example.biblioteca_java.Data.Libro;
import com.example.biblioteca_java.R;
import com.example.biblioteca_java.RecycleView.RecycleViewList;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Biblioteca} factory method to
 * create an instance of this fragment.
 */
public class Biblioteca extends Fragment {
    public ArrayList<Libro> libros = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biblioteca, container, false);
        RecyclerView recyclerView= view.findViewById(R.id.recyclerViewLibro);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RecycleViewList adapter = new RecycleViewList(libros);
        recyclerView.setAdapter(adapter);
        ConnexionFirebase firebase = new ConnexionFirebase();
        firebase.getBooks(new ConnexionFirebase.OnGetBooksListener() {
            @Override
            public void onSuccess(ArrayList<Libro> books) {
                libros.clear();
                libros.addAll(books);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                Log.e("Firebase", message);
            }
        });
        return view;
    }
}