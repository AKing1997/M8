package es.kankit.camkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.login_btn)

        boton.setOnClickListener {
            val redrige = Intent(this, Landing::class.java)
            startActivity(redrige)
        }
        val bottomNav: BottomNavigationView = findViewById(R.id.main_nav)

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.btn_home -> {
                    loadFragment(FromFragment())
                    true
                }
                else -> {false}
            }
        }



    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    }
}