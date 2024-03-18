package com.example.appcitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class activity_Registrar_Segunda_Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_segunda_pagina)

        val BtnRegistrarse = findViewById<ImageButton>(R.id.btnRegistrarme)
        BtnRegistrarse.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, VistaRegistrar::class.java)
                startActivity(intent)
            }

        })
    }

}

