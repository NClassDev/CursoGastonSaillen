package com.example.cursogastonsaillen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {

    private var nombre: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        intent.extras?.let { bundle ->
            nombre = bundle.getString("nombre")
        }

        val button = findViewById<Button>(R.id.btn_second_activity)
        val texto = findViewById<TextView>(R.id.txt_mensaje_segunda_activity)

        texto.text = nombre

        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("nombre2", "Mensaje desde segunda activity")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}