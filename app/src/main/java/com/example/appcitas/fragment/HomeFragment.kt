

package com.example.appcitas.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.appcitas.R

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_match,container, false)
        // se usa para obtener una referencia al botón con el ID
        val buttonc = view.findViewById<ImageButton>(R.id.Btn_Amistad)
        buttonc.setOnClickListener {
            //    cuando se le da click al boton llama al metodo navegar
            navigateConfig()
        }

        return view

    }

    private fun navigateConfig() {
        val activity = requireActivity() //Esta línea obtiene una referencia a la actividad que contiene este fragmento
        val fragmentManager = activity.supportFragmentManager // es responsable de administrar los fragmentos dentro de una actividad.
        //Aquí se inicia una nueva transacción de fragmentos. es decir agregar, reemplazar o quitar fragmentos, esto se realizan dentro de una transacción.
        val fragmentTransaction = fragmentManager.beginTransaction()
        //Se reemplaza el fragmento por el ID del otro fragmento
        fragmentTransaction.replace(R.id.fragmentContainer, MatchAmistad())
        //Esta línea permite al usuario retroceder a la transacción anterior al retroceder desde el dispositivo
        fragmentTransaction.addToBackStack(null)
        //se confirma la transacción, lo que efectivamente aplica todos los cambios realizados en la transacción de fragmentos
        fragmentTransaction.commit()

    }

}
