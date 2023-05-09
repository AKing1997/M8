package com.example.tictactoejava;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {
    private String ip;
    private String port;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        BottomNavigationView bottomNav = findViewById(R.id.nav);
        String fragment = getIntent().getStringExtra("FRAGMENT");
        ip = getIntent().getStringExtra("IP");
        port = getIntent().getStringExtra("PORT");

        if (fragment.equals("online")) {
            loadFragment(new Online(ip, port));
        } else {
            loadFragment(new OffLine(ip, port));
        }

        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.offLineNav:
                    loadFragment(new OffLine(ip,port));
                    return true;
                case R.id.onlineNav:
                    loadFragment(new Online(ip, port));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
