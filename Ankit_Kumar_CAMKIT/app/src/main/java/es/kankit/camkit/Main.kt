package es.kankit.camkit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class Main : AppCompatActivity() {
    private val key = "USER_KEY"
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Creando varible para guardar campo username
        val inputLoginUser: EditText = findViewById(R.id.inputLoginUser);
        // Creando varible para guardar campo contraseña
        val inputLoginPassword: EditText = findViewById(R.id.inputLoginPassword);
        // Creando varible para guardar campo boton entrar
        val btnSingIn: Button = findViewById(R.id.btnSignIn)
        // Asignando text en el campo username y contraseña para siempre estar introduciendo cada poco
        inputLoginUser.setText("admin");
        inputLoginPassword.setText("admin");
        // Creando un evento que estara escuchando cada poco al boton entrar para el ususario inicie sesion
        btnSingIn.setOnClickListener {
            // Una validacion de que el username y la contraseña sea igual para poder entrar
            if((inputLoginPassword.text.toString()).equals(inputLoginUser.text.toString())){
                // Iniciando un variabe que contiene el fragmento que redige a el fragment Landing
                val redrige = Intent(this, Landig::class.java);
                // Iniciamos el fragmento
                startActivity(redrige);
            }
        }
    }
}
