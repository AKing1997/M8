package es.kankit.camkit

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import es.kankit.camkit.DB.DBHelper
import es.kankit.camkit.Landig.Companion.dbHelper

class UserPreference : AppCompatActivity() {
    var db: DBHelper = dbHelper;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference)
        val sharedPreference: SharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE);
        val backImageButton: ImageButton = findViewById(R.id.backImageButton);
        val deletePerf: Button = findViewById(R.id.deletePerf);
        val btnDeleteAll: Button = findViewById(R.id.btnDeleteAll);
        val language = sharedPreference.getString("lang", "en");
        var alertMesPerf = "";
        var alertMesDb = "";
        when (language) {
            "en" -> {
                alertMesPerf ="Are you sure you want to remove all preferences!";
                alertMesDb = "Are you sure you want to delete all data!";
            }
            "es" -> {
                alertMesPerf = "Estas seguro que deseas eliminar todos las preferencias!";
                alertMesDb = "Estas seguro que deseas eliminar todos los datos!";
            }
            "ca" -> {
                alertMesPerf = "Estàs segur que vols eliminar totes les preferències!";
                alertMesDb = "Estàs segur que vols eliminar totes les dades!";
            }
        }
        // boton para retornar a atras
        backImageButton.setOnClickListener{
            onBackPressed();
        }

        // boton para eliminar todas las perferencias de usuario
        deletePerf.setOnClickListener({
            val confirmacion = AlertDialog.Builder(this);
            confirmacion.setMessage(alertMesPerf)
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                       sharedPreference.edit().clear().commit();
                        startActivity(Intent(this, Main::class.java));
                        //Toast.makeText(this, "Hello Javatpoint", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        //noting to implement
                    })
            // Create the AlertDialog object and return it
            confirmacion.create().show()
        })

        //val settingsBtn: ImageButton = view.findViewById(R.id.settingBtn);
        btnDeleteAll.setOnClickListener {
            val confirmacion = AlertDialog.Builder(this);
            confirmacion.setMessage(alertMesDb)
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        db.deleteAllCryptos();
                        //Toast.makeText(this, "Hello Javatpoint", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        // nathig to implement
                    })
            // Create the AlertDialog object and return it
            confirmacion.create().show()
        };
    }
}