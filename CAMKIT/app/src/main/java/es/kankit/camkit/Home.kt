package es.kankit.camkit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
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

class Home : Fragment() {
    companion object{
        lateinit var listas: ArrayList<CryptoGecko>;
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false);
        var cryptoListHomeRecyle: ConstraintLayout = view.findViewById(R.id.cryptoListHomeRecyle);
        var progresContraintLayoutHome: ConstraintLayout = view.findViewById(R.id.progresContraintLayoutHome);

        //Creando la conexion
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val serviceCrypto = retrofit.create(CryptoGeckoAPI::class.java)

        //Preparando la consulta
        val call: Call<ArrayList<CryptoGecko>?>? = serviceCrypto.getCryptoList("100", Currency.EUR, "1")

        call?.enqueue(object : Callback<ArrayList<CryptoGecko>?> {
            override fun onResponse(call: Call<ArrayList<CryptoGecko>?>, response: Response<ArrayList<CryptoGecko>?>) {
                //obteniendo la consulta y guardando el lista
                listas = response?.body()!!;
                // creando una variable que contiene el recicler view Lista y lo adapta
                var recyclerView: RecyclerView = view.findViewById(R.id.recycleListHome);
                recyclerView.layoutManager = LinearLayoutManager(context);
                val adapter : RecycleViewList = RecycleViewList(listas, context, DBHelper(view.context));
                recyclerView.adapter = adapter;

                //Ocultado el progreso una ves tenido la consulta
                progresContraintLayoutHome.visibility = View.GONE;
                //Activando la vista de recycleView una ves tenido la consulta
                cryptoListHomeRecyle.visibility = View.VISIBLE;
                Log.i("testapi", Gson().toJson(listas))
            }
            override fun onFailure(call: Call<ArrayList<CryptoGecko>?>?, t: Throwable?) {
                t?.printStackTrace();
            }
        })
        return view
    }
}