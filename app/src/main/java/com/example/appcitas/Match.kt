package com.example.appcitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


import com.example.appcitas.fragment.ConfiguracionFragment
import com.example.appcitas.fragment.HomeFragment
import com.example.appcitas.fragment.NotificacionesFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class Match : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)


        // Le asigna un Id a cada codigo para despues llamar el boton con su icono
        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Notificacion",R.drawable.baseline_people_alt_24)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"home",R.drawable.icono_usuario_registrar)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Configuracion",R.drawable.baseline_comment_24)
        )

        bottomNavigation.setOnClickMenuListener{
            when (it.id){
                //llama la actividad NotificacionesFragment donde llama  la vista
                //fragment_notificacion y el numero del id que asignamos anteriormente
                1 -> {
                    replaceFragment(NotificacionesFragment())
                }
                2 -> {
                    replaceFragment(HomeFragment())
                }
                3 -> {
                    replaceFragment(ConfiguracionFragment())
                }

            }

        }
        // Esta linea de codigo sirve para escoger en donde aparecera el boton que
        // en este caso aparecera en el circulito 2 que es home
        replaceFragment(HomeFragment())
        bottomNavigation.show(2 )
    }
        // Funcion que sirve para reemplazar el fragmento por otro y asi reutilizar conponentes
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }


}