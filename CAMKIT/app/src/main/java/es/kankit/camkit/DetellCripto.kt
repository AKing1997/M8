package es.kankit.camkit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetellCripto(get: Criptomoneda) : Fragment() {
    var cripto = get;
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_detell_cripto, container, false);
        // Creando variables que contiene todos los text views para despues asignar el texto al campo que pertenece
        val textDetailName: TextView = view.findViewById(R.id.textDetailName);
        val textDetailType: TextView = view.findViewById(R.id.textDetailType);
        val textDetailHash: TextView = view.findViewById(R.id.textDetailHash);
        textDetailName.setText(cripto.getName().toString());
        textDetailType.setText(cripto.getType().toString());
        textDetailHash.setText(cripto.getHash().toString());

        return view;
    }
}