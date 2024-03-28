package com.example.appcitas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcitas.R

// Definición de la clase de datos Message
data class Message(val text: String, val sender: String, val timestamp: Long) {
    // Método para verificar si el mensaje fue enviado por un usuario específico y lo compara con el remitente
    fun isSentByMe(userId: String): Boolean {
        return sender == userId
    }
}

// Clase que define el adaptador para el RecyclerView que muestra los mensajes
class MessageAdapter (private val messageList: List<Message>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    // Método que crea un nuevo ViewHolder cuando se necesita una nueva vista para mostrar un elemento de la lista o un mensaje
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    // Método que vincula los datos del mensaje con la vista correspondiente en el ViewHolder
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]
        holder.bind(message)
    }

    // Método que devuelve el tamaño de la lista de mensajes, determinando cuántos elementos se mostrarán en el RecyclerView
    override fun getItemCount(): Int {
        return messageList.size
    }

    // Clase interna que representa un ViewHolder para un elemento de mensaje en el RecyclerView
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: Message) {
            val ImgViewMeNSAJES : ImageView = itemView.findViewById(R.id.imgRecibeChat)
            // Referenciar los TextViews en el ViewHolder
            val textViewSentMessage: TextView = itemView.findViewById(R.id.textViewSentMessage)
            val textViewReceivedMessage: TextView = itemView.findViewById(R.id.textViewReceivedMessage)
            if (message.sender == "Me") {
                // Mostrar mensaje enviado por ti
                ImgViewMeNSAJES.visibility= View.GONE
                textViewSentMessage.visibility = View.VISIBLE
                textViewReceivedMessage.visibility = View.GONE
                textViewSentMessage.text = message.text
            } else {
                // Mostrar mensaje recibido
                textViewSentMessage.visibility = View.GONE
                textViewReceivedMessage.visibility = View.VISIBLE
                textViewReceivedMessage.text = message.text
            }
        }
    }
}