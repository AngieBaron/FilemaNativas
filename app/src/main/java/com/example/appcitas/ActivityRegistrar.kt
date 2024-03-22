package com.example.appcitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class ActivityRegistrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val BtnContinuar = findViewById<ImageButton>(R.id.btnContinuar)
        BtnContinuar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext,activity_Registrar_Segunda_Pagina::class.java)
                startActivity(intent)
            }

        })
        val BtnAtras = findViewById<ImageButton>(R.id.btnDevolver)
        BtnAtras.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext,Login::class.java)
                startActivity(intent)
            }

        })
    }
}