package es.kankit.camkit

import android.app.AlertDialog
import android.content.DialogInterface
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import es.kankit.camkit.DB.DBHelper

class Profil(dbHelper: DBHelper) : Fragment() {

        var db: DBHelper= dbHelper;

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val view: View = inflater.inflate(R.layout.fragment_profil, container, false);
        // Inflate the layout for this fragment
         // La variable que contiene el botton eliminar todos los datos de base de datos con el evento puesto y con confirmacion con "Alert"
         val btnDeleteAll: Button = view.findViewById(R.id.btnDeleteAll);
         btnDeleteAll.setOnClickListener {
             val confirmacion = AlertDialog.Builder(context);
             confirmacion.setMessage("Estas seguro que deseas eliminar todos los datos!")
                 .setPositiveButton("OK",
                     DialogInterface.OnClickListener { dialog, id ->
                         db.deleteAllCryptos();
                         //Toast.makeText(this, "Hello Javatpoint", Toast.LENGTH_SHORT).show()
                     })
                 .setNegativeButton("Cancelar",
                     DialogInterface.OnClickListener { dialog, id ->
                         Toast.makeText(context, "Se ha cancelado!",Toast.LENGTH_SHORT).show();
                     })
             // Create the AlertDialog object and return it
             confirmacion.create().show()
         };
        return view;
    }
}