package com.example.uf3p3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inicializar extends AppCompatActivity {
    private EditText userName;
    private TextView erMsg;
    private Button initChatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicializar);
        userName = findViewById(R.id.userName);
        initChatBtn = findViewById(R.id.initChat);
        erMsg = findViewById(R.id.erMsg);
        Intent redrige = new Intent(this, MainActivity.class);
        initChatBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!userName.getText().toString().isEmpty()){
                    erMsg.setVisibility(View.GONE);
                    redrige.putExtra("UserName", userName.getText().toString());
                    startActivity(redrige);
                }else{
                    erMsg.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}