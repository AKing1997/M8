package com.example.biblioteca_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreference = this.getSharedPreferences(
                "BIBLIOTECA", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPreference.edit();
        EditText pass = findViewById(R.id.passwordInput);
        EditText email = findViewById(R.id.userInput);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        email.setText("admin");
        pass.setText("admin");
        Intent redrige = new Intent(this, MainActivity.class);
        buttonLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (pass.getText().toString().equals(email.getText().toString())){
                    edit.putString("user", email.getText().toString());
                    edit.putString("pass", pass.getText().toString());
                    edit.commit();
                    //val usuario: IUser = IUser(1,userInput.text.toString(),passwordInput.text.toString());
                    startActivity(redrige);
                }
            }
        });
    }
}