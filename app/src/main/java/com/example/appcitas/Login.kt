package com.example.appcitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val BtnRegistrar = findViewById<ImageButton>(R.id.btnRegistrar)
        BtnRegistrar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext,ActivityRegistrar::class.java)
                startActivity(intent)
            }

        })
        val BtnEntrar = findViewById<ImageButton>(R.id.btnEntrarPrincipal)
        BtnEntrar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext,Match::class.java)
                startActivity(intent)
            }

        })

        val BtnVerificarCorreoContraseña=findViewById<ImageButton>(R.id.btnEntrarPrincipal)
        BtnVerificarCorreoContraseña.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val TxtEmail = findViewById<TextView>(R.id.TxtIngresarEmail)
                val txtContrasena=findViewById<TextView>(R.id.TxtIngresarContraseña)
                if (TxtEmail.text.toString()=="" && txtContrasena.text.toString()==""  ){
                    val intent = Intent(applicationContext,Match::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext,"Se ha producido un error, datos incorrectos", Toast.LENGTH_SHORT).show()
                    return
                }
            }

        }
        )

    }



}