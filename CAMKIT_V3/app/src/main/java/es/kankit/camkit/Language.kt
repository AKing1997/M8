package es.kankit.camkit

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.*
import java.util.*

class Language : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        var sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE);
        var editorSharedPreferences = sharedPreference.edit();
        val languageGroup: RadioGroup= findViewById(R.id.languageGroup);
        val language = sharedPreference.getString("lang", "en");
        var en: RadioButton = findViewById(R.id.ingles);
        var es: RadioButton = findViewById(R.id.spanish);
        var ca: RadioButton = findViewById(R.id.catala);
        when (language) {
            "en" -> {
                en.setChecked(true);
            }
            "es" -> {
                es.setChecked(true);
            }
            "ca" -> {
                ca.setChecked(true);
            }
        }
        val backImageButton: ImageButton = findViewById(R.id.backImageButton2);
        backImageButton.setOnClickListener{
            onBackPressed();
        }

        // Segun selecionado de RadioGroup para cambiar el lenguaje
        languageGroup.setOnCheckedChangeListener { radioGroup, i ->
            val value = ((findViewById(radioGroup.getCheckedRadioButtonId()) as RadioButton).text).toString();
            var messageC="";
            if (value.equals("Ingles")) {
                setAppLocale("en");
                editorSharedPreferences.putString("lang", "en");
                editorSharedPreferences.commit();
                messageC = "The selected language has been changed ";// Pirates are the best
            }else if (value.equals("Spanish")) {
                setAppLocale("es");
                editorSharedPreferences.putString("lang", "es");
                editorSharedPreferences.commit();
                messageC = "Se ha cambiado la idioma seleccionada ";
            }else if (value.equals("Catalan")) {
                setAppLocale("ca");
                editorSharedPreferences.putString("lang", "ca");
                editorSharedPreferences.commit(); // Ninjas
                messageC = "S'ha canviat l'idioma seleccionada ";// rule
            }
            Toast.makeText(this,messageC + value, Toast.LENGTH_SHORT).show();
        }
    }

    private fun setAppLocale(localeCode: String) {
        val resources: Resources = resources;
        val dm: DisplayMetrics = resources.getDisplayMetrics();
        val config: Configuration = resources.getConfiguration();
        config.setLocale(Locale(localeCode.lowercase(Locale.getDefault())));
        resources.updateConfiguration(config, dm);
        startActivity(Intent(this, Main::class.java));
    }

}