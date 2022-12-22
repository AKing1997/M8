package es.kankit.camkit

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.kankit.camkit.DB.DBHelper

class List(dbHelper: DBHelper, context: Context) : Fragment() {
    // creando una variable que contiene DataBase helper
    val db: DBHelper = dbHelper;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // creando una variable que contiene el view
        var view: View= inflater.inflate(R.layout.fragment_list,container, false)
        // creando una variable de tipo arrayList
        var listas: ArrayList<Criptomoneda> = db.getListaCriptos();
        // creando una variable que contiene el recicler view Lista y lo adapta
        var recyclerView: RecyclerView = view.findViewById(R.id.recycleList);
        recyclerView.layoutManager = LinearLayoutManager(context);
        val adapter : RecycleViewList = RecycleViewList(listas, context, db);
        recyclerView.adapter = adapter;
        val sharedPreference: SharedPreferences = view.context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE);
        val language = sharedPreference.getString("lang", "en");
        var alertMesDel = "";

        // Configurando el lenguage
        when (language) {
            "en" -> {
                alertMesDel ="Are you sure you want to delete";
            }
            "es" -> {
                alertMesDel = "Estas seguro que deseas eliminar";
            }
            "ca" -> {
                alertMesDel = "Estàs segur que vols eliminar";
            }
        }
        //Creando un objeto que esta escuchando al hacer swipe para eliminar elementos criptos
        val swipeToDeleteCallback = object : SwipeToDeleteCallback(context){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var position = viewHolder.adapterPosition
                val item = listas.get(position).id;
                val confirmacion = AlertDialog.Builder(context);
                confirmacion.setMessage("¿ ${alertMesDel} ${listas.get(position).getName()}?")
                    .setPositiveButton("Yes",
                        DialogInterface.OnClickListener
                        { dialog, id ->
                            db.deleteCrypto(item);
                            listas.removeAt(position);
                                recyclerView.adapter = adapter;
                        })
                    .setNegativeButton("No",
                        DialogInterface.OnClickListener
                        { dialog, id ->
                            recyclerView.adapter = adapter;
                        })
                // Create the AlertDialog object and return it
                confirmacion.create().show();
            }

        }
        // Insertando a cada elemento swipe delete callback
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return view
    }

}