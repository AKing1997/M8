package com.example.tresenralla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Nav extends AppCompatActivity {
    private String ip;
    private String port;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        String fragment = getIntent().getStringExtra("FRAGMENT");
        ip = getIntent().getStringExtra("IP");
        port = getIntent().getStringExtra("PORT");

        if (fragment.equals("online")) {
            loadFragment(new Online(ip, port));
        } else {
            loadFragment(new OffLine(ip, port));
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.offLineNav:
                    loadFragment(new OffLine(ip,port));
                    break;
                case R.id.onlineNav:
                    loadFragment(new Online(ip, port));
                    break;;
            }
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
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
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}