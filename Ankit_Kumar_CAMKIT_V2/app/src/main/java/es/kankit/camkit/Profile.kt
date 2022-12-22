package es.kankit.camkit

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceManager
import es.kankit.camkit.DB.DBHelper

class Profile(dbHelper: DBHelper) : Fragment() {
     @SuppressLint("MissingInflatedId")
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val view: View = inflater.inflate(R.layout.fragment_profile, container, false);
         // Inflate the layout for this fragment
         // La variable que contiene el botton eliminar todos los datos de base de datos con el evento puesto y con confirmacion con "Alert"
         val sharedPreference: SharedPreferences = view.context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE);
         var editor = sharedPreference.edit();
         val settingBtn: Spinner = view.findViewById(R.id.settingBtn);
         val aA = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.spinner_setting));
         aA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         settingBtn.adapter = aA;

         // Creando un seleccion de item del array sring para la configuraciones
         settingBtn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
             override fun onItemSelected(
                 parent: AdapterView<*>?,
                 view: View,
                 position: Int,
                 id: Long
             ) {
                 if (position == 0) {
                     val language = Intent(context, Language::class.java);
                     startActivity(language);
                 } else if (position == 1) {
                     val redrige = Intent(context, UserPreference::class.java);
                     startActivity(redrige);
                 } else if (position == 2) {
                     // Eliminar el usuario guardado
                     editor.remove("Recordame").commit();
                     editor.clear().commit();
                     val redrige = Intent(context, Main::class.java);
                     startActivity(redrige);
                 }
             }

             override fun onNothingSelected(p0: AdapterView<*>?) {
                 TODO("Not yet implemented")
             }

         }
         return view;
     }

}