package es.kankit.camkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import es.kankit.camkit.DB.DBHelper

class Landig : AppCompatActivity() {;
    companion object {// Creando una variable que iniciara mas tarde
        lateinit var dbHelper:DBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landig)
        // Creando una variable para los botones de menu navegacion
        val bottomNav: BottomNavigationView = findViewById(R.id.nav)
        // inicializando de base de datos o sea el variable que contiene
        dbHelper = DBHelper(this);
        // Una funcion que hace que inicie el fragment Home por defecto
        defaultPage();
        // creando un evento para que escuche clicks en menu navigation
        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            // condicione como Switch
            when (item.itemId) {
                R.id.btn_home -> {// Frgmento Home
                    loadFragment(Home())
                    true
                }
                R.id.btn_portafolio -> {// fragmento List
                    loadFragment(List(dbHelper))
                    true
                }// Frgmento de perfil donde tiene boton eliminar todo
                R.id.btn_profile -> {
                    loadFragment(Profil(dbHelper))
                   true
                }// Este fragmento es de Formulario
                R.id.btn_chat -> {
                    loadFragment(Form(dbHelper))
                    true
                }// La opcion por defecto
                else -> {false}
            }
        }
    }

    // Funcion fragmento por defecto
    private fun defaultPage(){
        loadFragment(Home());
    }
    // Funcion que recibe el fragmento y lo inicializa
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit()
    }

    // Hace un destroy o cierre de base de datos del variable dbHelper
    override fun onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

}

