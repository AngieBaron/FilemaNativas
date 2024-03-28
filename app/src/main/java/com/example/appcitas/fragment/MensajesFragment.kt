package com.example.appcitas.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.appcitas.Chat
import com.example.appcitas.R

class MensajesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Trae la vista que esta en el layout
        val view = inflater.inflate(R.layout.fragment_mensajes, container, false)

        //Boton que me lleva al activity de chat
        val Btncha = view.findViewById<Button>(R.id.EnvioChat)
        Btncha.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(activity, Chat::class.java)
                //Toast.makeText(activity, "pasando a chat", Toast.LENGTH_SHORT).show();
                startActivity(intent)
            }
        })

        return view
    }

}