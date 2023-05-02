package es.kankit.camkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash);

        val redrige = Intent(this, Main::class.java);
        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            run(){
                startActivity(redrige);
                finish();
            }
        },2000);
    }
}