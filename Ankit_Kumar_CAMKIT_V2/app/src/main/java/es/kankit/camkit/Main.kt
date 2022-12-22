package es.kankit.camkit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.*

class Main : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declarando variable sharedPreference
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE);
        var editorSharedPreferences = sharedPreference.edit();
        if(sharedPreference.getString("lang", "en") == "en"){
            editorSharedPreferences.putString("lang", "en");
            editorSharedPreferences.commit();
        }
        setAppLocale(sharedPreference.getString("lang", "en").toString());
        // Iniciando un variabe que contiene el fragmento que redige a el fragment Landing
        val redrige = Intent(this, Landig::class.java);
        if(sharedPreference.getBoolean("Recordame", false)==true){
            startActivity(redrige);
        }else{
            // Creando varible para guardar campo username
            val inputLoginUser: EditText = findViewById(R.id.inputLoginUser);
            // Creando varible para guardar campo contraseña
            val inputLoginPassword: EditText = findViewById(R.id.inputLoginPassword);
            // Creando variable para obtener si el ususario quiere guardar inicio de sesion
            val checkBoxRecordameLogin: CheckBox= findViewById(R.id.checkBoxRecordameLogin);
            // Creando varible para guardar campo boton entrar
            val btnSingIn: Button = findViewById(R.id.btnSignIn)
            // Asignando text en el campo username y contraseña para siempre estar introduciendo cada poco
            inputLoginUser.setText("admin");
            inputLoginPassword.setText("admin");
            // Creando un evento que estara escuchando cada poco al boton entrar para el ususario inicie sesion
            btnSingIn.setOnClickListener {
                // Una validacion de que el username y la contraseña sea igual para poder entrar
                if((inputLoginPassword.text.toString()).equals(inputLoginUser.text.toString())){
                    if(checkBoxRecordameLogin.isChecked) {
                        editorSharedPreferences.putBoolean("Recordame", true);
                        editorSharedPreferences.commit();
                    }
                    // Iniciamos el fragmento
                    startActivity(redrige);
                }
            }
        }
    }
    private fun setAppLocale(localeCode: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        config.setLocale(Locale(localeCode.lowercase(Locale.getDefault())))

        resources.updateConfiguration(config, dm)
    }
}
