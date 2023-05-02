package com.example.biblioteca_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.biblioteca_java.Fragments.Add;
import com.example.biblioteca_java.Fragments.Biblioteca;
import com.example.biblioteca_java.Fragments.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        defaultPage();
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.libro:
                    loadFragment(new Biblioteca());
                    break;
                case R.id.add:
                    loadFragment(new Add());
                    break;
            }
            return true;
        });
    }
    private void defaultPage(){
        loadFragment(new Add());
    }
    // Funcion que recibe el fragmento y lo inicializa
    public void loadFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}