package com.example.appcitas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcitas.R
import com.example.appcitas.model.Usuarios

class UserAdapter(private val usuariosList: List<Usuarios>) : RecyclerView.Adapter<UsuarioViewHolder>() {

    // Método llamado cuando RecyclerView necesita crear un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        // Crear un LayoutInflater para inflar el diseño del elemento de usuario
        val layoutInflater = LayoutInflater.from(parent.context)
        // Inflar el diseño del elemento de usuario y crear un UsuarioViewHolder con él
        return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    // Método llamado para obtener el número total de elementos en el conjunto de datos
    override fun getItemCount(): Int = usuariosList.size

    // Método llamado cuando RecyclerView necesita mostrar los datos en una posición específica
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        // Obtener el objeto Usuarios en la posición especificada
        val item = usuariosList[position]
        // Llamar al método render del ViewHolder para mostrar los datos en la posición actual
        holder.render(item)
    }
}
