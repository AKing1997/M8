package es.kankit.camkit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import es.kankit.camkit.Interficie.CryptoGecko

class DetellCripto(get: CryptoGecko) : Fragment() {
    var cripto = get;
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_detell_cripto, container, false);
        // Creando variables que contiene todos los text views para despues asignar el texto al campo que pertenece
        val imgCryptoCoin: ImageView = view.findViewById(R.id.imgDetaillCoin);
        val textDetailName: TextView = view.findViewById(R.id.textDetailName);
        val textDetailType: TextView = view.findViewById(R.id.textDetailType);
        val textDetailRank: TextView = view.findViewById(R.id.textDetailRank);
        val txtPrecio: TextView = view.findViewById(R.id.txtPrecio);
        Glide.with(view)
            .load(cripto.image.toString())
            .into(imgCryptoCoin);
        textDetailName.setText("Nombre:- ${cripto.name.toString()}");
        textDetailType.setText("Red:- "+cripto.symbol.toString());
        textDetailRank.setText("Rank:- "+cripto.market_cap_rank.toString());
        txtPrecio.setText("Pecio:- "+cripto.current_price.toString()+" €");

        return view;
    }
}