package es.kankit.camkit

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import es.kankit.camkit.Constant.Currency
import es.kankit.camkit.DB.DBHelper
import es.kankit.camkit.Interficie.CryptoGecko
import es.kankit.camkit.Interficie.CryptoGeckoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class List(dbHelper: DBHelper, context: Context) : Fragment() {
    // creando una variable que contiene DataBase helper
    val db: DBHelper = dbHelper;
    companion object{
        lateinit var listas: ArrayList<CryptoGecko>;
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // creando una variable que contiene el view
        var view: View= inflater.inflate(R.layout.fragment_list,container, false)
        /*// creando una variable de tipo arrayList
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val serviceCrypto = retrofit.create(CryptoGeckoAPI::class.java)
        val call: Call<ArrayList<CryptoGecko>?>? = serviceCrypto.getCryptoList("25", Currency.EUR, "1")

        call?.enqueue(object : Callback<ArrayList<CryptoGecko>?> {
            override fun onResponse(call: Call<ArrayList<CryptoGecko>?>, response: Response<ArrayList<CryptoGecko>?>) {
                listas = response?.body()!!;
                // creando una variable que contiene el recicler view Lista y lo adapta
                var recyclerView: RecyclerView = view.findViewById(R.id.recycleList);
                recyclerView.layoutManager = LinearLayoutManager(context);
                val adapter : RecycleViewList = RecycleViewList(listas, context, db);
                recyclerView.adapter = adapter;
                Log.i("testapi", Gson().toJson(listas))
            }
            override fun onFailure(call: Call<ArrayList<CryptoGecko>?>?, t: Throwable?) {
                t?.printStackTrace();
            }
        })*/


        //He comentado este codigo poque demomento no lo usare es de Swipe para eliminar un elemento de la lista
       /* val sharedPreference: SharedPreferences = view.context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE);
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
                val item = listas.get(position);
                val confirmacion = AlertDialog.Builder(context);
                confirmacion.setMessage("¿ ${alertMesDel} ${listas.get(position)}?")
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

                        })
                // Create the AlertDialog object and return it
                confirmacion.create().show();
                recyclerView.adapter = adapter;
            }
        }
        // Insertando a cada elemento swipe delete callback
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);*/
        return view
    }

}