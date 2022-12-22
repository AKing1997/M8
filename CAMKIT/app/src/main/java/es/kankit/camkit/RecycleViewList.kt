package es.kankit.camkit

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import es.kankit.camkit.DB.DBHelper

class RecycleViewList(
    listas: ArrayList<Criptomoneda>,
    context: Context?,
    dbHelper: DBHelper
) : RecyclerView.Adapter<RecycleViewList.ViewHolder>() {
    var listas: ArrayList<Criptomoneda> = listas;
    var context: Context? = context;
    var db: DBHelper = dbHelper;
    // Return cantidad de items en el recycler/lista
    override fun getItemCount(): Int {
        return listas.size;
    }

    //Asociar la información que queremos mostrar en el item list
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
            holder.txtNom.setText(listas.get(position).getName());
            holder.txtHash.setText(listas.get(position).getHash());
       // Creando un evento para que escuche a itemView o sea cuando haga click en objeto y le redrigue en Detalle de Cripto
            holder.itemView.setOnClickListener(object:View.OnClickListener{
                override fun onClick(v: View?) {
                    Log.i("test","ankit");
                    val activity = v!!.context as AppCompatActivity
                    activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                        DetellCripto(listas.get(holder.adapterPosition))).addToBackStack(null).commit();
                }
            })

    }

    //Devueve el item que voy a mostrar en el recycler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  layoutInflater = LayoutInflater.from(parent.context);
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }


    //Definir los campos de mi item list
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtNom: TextView = view.findViewById(R.id.textName);
        val txtHash : TextView = view.findViewById(R.id.textHash);
    }
}