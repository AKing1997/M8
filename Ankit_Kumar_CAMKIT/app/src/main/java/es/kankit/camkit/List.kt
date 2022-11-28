package es.kankit.camkit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.kankit.camkit.DB.DBHelper

class List(dbHelper: DBHelper) : Fragment() {
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

        return view
    }

}