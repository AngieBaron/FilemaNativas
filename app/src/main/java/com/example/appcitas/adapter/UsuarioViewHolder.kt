package com.example.appcitas.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcitas.databinding.ItemUserBinding
import com.example.appcitas.model.Usuarios

class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Utilizando View Binding para acceder a las vistas dentro del diseño del elemento de usuario
    val binding = ItemUserBinding.bind(view)

    // Método para renderizar los datos del usuario en las vistas correspondientes
    fun render(userModel: Usuarios) {
        // Asignar el nombre del usuario al TextView correspondiente
        binding.UsuarioName.text = userModel.Name
        // Asignar la descripción del usuario al TextView correspondiente
        binding.UsuarioDescripcion.text = userModel.Description
        // Cargar la imagen del usuario utilizando Glide y asignarla al ImageView correspondiente
        Glide.with(binding.UsuarioFoto.context).load(userModel.photo).into(binding.UsuarioFoto)
    }
}