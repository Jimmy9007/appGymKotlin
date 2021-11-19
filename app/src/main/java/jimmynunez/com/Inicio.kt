package jimmynunez.com

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val button: Button = findViewById(R.id.btnIniciarSesion)
        button.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}