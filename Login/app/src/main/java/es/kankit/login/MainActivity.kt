package es.kankit.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSignIn: Button = findViewById(R.id.btnSignIn)
        var txtUsername: EditText = findViewById(R.id.txtUsername)
        var txtPassword:EditText = findViewById(R.id.txtPassword)
        var lblLoginResult: TextView = findViewById(R.id.lblLoginResult)

        btnSignIn.setOnClickListener{
            var intent = Intent(this, ButtonNavigation::class.java);
            startActivity(intent);
        }
    }
}