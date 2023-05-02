package es.kankit.camkit

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.kankit.camkit.DB.DBHelper
import es.kankit.camkit.Interficie.CryptoGecko
import kotlin.math.roundToInt

class RecycleViewList(
    listas: ArrayList<CryptoGecko>,
    context: Context?,
    dbHelper: DBHelper
) : RecyclerView.Adapter<RecycleViewList.ViewHolder>() {
    var listas: ArrayList<CryptoGecko> = listas;
    var context: Context? = context;
    var db: DBHelper = dbHelper;
    // Return cantidad de items en el recycler/lista
    override fun getItemCount(): Int {
        return listas.size;
    }

    //Asociar la información que queremos mostrar en el item list
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.recyclePosicion.setText(listas.get(position).market_cap_rank.toString())
            holder.txtNom.setText(listas.get(position).name.toString());
            holder.txtPriceCrypto.setText(((((listas.get(position).current_price)?.times(100.0))?.roundToInt()
                ?: 0) / 100.0).toString()+" €");
        Glide.with(holder.itemView)
            .load(listas.get(position).image.toString())
            .into(holder.imgCryptoCoin);
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
        val recyclePosicion: TextView = view.findViewById(R.id.recyclePosicion);
        val txtNom: TextView = view.findViewById(R.id.textName);
        val imgCryptoCoin: ImageView = view.findViewById(R.id.coinImage);
        val txtPriceCrypto : TextView = view.findViewById(R.id.txtPriceCrypto);
    }
}