package com.example.appcitas.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.appcitas.R

class NotificacionesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notificacion, container, false)
        // Andres debe comentar esto
        val buttonc = view.findViewById<Button>(R.id.login_btn_prueba)
        buttonc.setOnClickListener {
            navigateLogin()
        }

        return view

    }

    //Andres debe comentar esto
    private fun navigateLogin(){
        val activity = requireActivity()
        val fragmentManager = activity.supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,ConfiguracionFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}

