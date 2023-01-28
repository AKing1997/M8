package es.kankit.camkit

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.kankit.camkit.Class.SearchList
import es.kankit.camkit.DB.DBHelper
import es.kankit.camkit.Interficie.CryptoGecko
import es.kankit.camkit.Interficie.CryptoGeckoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Search : Fragment() {
    companion object{
        lateinit var listas: SearchList;
        lateinit var list: ArrayList<CryptoGecko>;
        lateinit var progressBar: ProgressBar;
        lateinit var searchRecycleViewList: RecyclerView;

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_search, container, false);
        val searchView: EditText = view.findViewById(R.id.searchView);
        searchRecycleViewList= view.findViewById(R.id.searchRecycleViewList);
        progressBar = view.findViewById(R.id.progressBar);
        // aparatir de esta variable estamos creando la conexion con
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val serviceCrypto = retrofit.create(CryptoGeckoAPI::class.java);
        // Variable que tendra dependiendo de alguna moneda por defecto para poder visualizar en el fargment de Search
        var text = if (searchView.text.isEmpty()) "bitcoin,ethereum,bnb,xrp,cardano,dogecoin,shiba-indu,uniswap,litecoin,polkadot,solana" else searchView.text.toString() ;
        //Funcion que obtiene el la lista de crytos que sea ha pedido
        getSearchCripto(serviceCrypto, text, view);

        //Creando un evento que escucha a teclado
        searchView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // if para verificar que cuando precione el usuario teclado enter o accione
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Oculto la visibilidad de fragment RecycleViewList
                searchRecycleViewList.visibility = View.GONE;
                //Activo el progress bar
                progressBar.visibility = View.VISIBLE;

                text ="";
                // Para ocultar el teclado
                hideKeyboard();
                //preparo la llamada
                val call: Call<SearchList?> = serviceCrypto.getCryptoSearchList(searchView.text.toString());
                call?.enqueue(object : Callback<SearchList?> {
                    override fun onResponse(call: Call<SearchList?>, response: Response<SearchList?>) {
                        //obtengo la lista
                        listas  = response?.body()!!;
                        //recorro la lista.coins para solo extraer los ids de los cyptos
                        listas.coins.forEach {
                            var posicion = 0;
                            if( posicion < listas.coins.size){
                                text += it.id+",";
                                posicion++;
                            }else{
                                text += it.id;
                            }
                        }
                        //vuelvo setear la lista de busqueda en recycleView
                        getSearchCripto(serviceCrypto, text, view);
                    }
                    override fun onFailure(call: Call<SearchList?>, t: Throwable?) {
                        t?.printStackTrace();
                        Log.i("testapiS", "${t?.localizedMessage}")

                    }
                });
                return@OnKeyListener true
            }
            false
        })
        return view;
    }

    fun getSearchCripto(serviceCrypto: CryptoGeckoAPI, text: String, view: View){
        val callCyptoList: Call<ArrayList<CryptoGecko>?>? = serviceCrypto.getCryptoListByIds(text)
        callCyptoList?.enqueue(object : Callback<ArrayList<CryptoGecko>?> {
            override fun onResponse(call: Call<ArrayList<CryptoGecko>?>, response: Response<ArrayList<CryptoGecko>?>) {
                list = response?.body()!!;
                // creando una variable que contiene el recicler view Lista y lo adapta
                var recyclerView: RecyclerView = view.findViewById(R.id.searchRecycleViewList);
                recyclerView.layoutManager = LinearLayoutManager(context);
                val adapter : RecycleViewList = RecycleViewList(list, context, DBHelper(view.context));
                recyclerView.adapter = adapter;
                //Oculto el progress bar
                progressBar.visibility = View.GONE;
                // Activo la visibilidad de fragment RecycleViewList
                searchRecycleViewList.visibility = View.VISIBLE;
            }
            override fun onFailure(call: Call<ArrayList<CryptoGecko>?>?, t: Throwable?) {
                t?.printStackTrace();
            }
        })
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

