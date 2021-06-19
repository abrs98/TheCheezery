package barrios.abrahan.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnCold: Button = findViewById(R.id.button_cold_drinks) as Button

        btnCold.setOnClickListener(){

            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","coldDrinks")
            startActivity(intent)
        }



        val btnHot: Button = findViewById(R.id.button_hot_drinks) as Button

        btnHot.setOnClickListener(){
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","hotDrinks")
            startActivity(intent)
        }

        val btnSwe: Button = findViewById(R.id.button_sweets) as Button

        btnSwe.setOnClickListener(){
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","sweets")
            startActivity(intent)
        }

        val btnSal: Button = findViewById(R.id.button_salties) as Button

        btnSal.setOnClickListener(){
            val intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","salties")
            startActivity(intent)
        }


    }
}