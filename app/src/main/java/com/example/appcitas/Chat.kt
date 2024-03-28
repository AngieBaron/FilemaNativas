package com.example.appcitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcitas.adapter.Message
import com.example.appcitas.adapter.MessageAdapter
import com.example.appcitas.fragment.MensajesFragment

class Chat : AppCompatActivity() {
    private lateinit var recyclerViewChat: RecyclerView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: ImageView
    private lateinit var BtnAtra: ImageView
    private lateinit var adapter: MessageAdapter
    private var messageList: MutableList<Message> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //Funcionalidad del boton volver
        BtnAtra = findViewById(R.id.backChat)
        BtnAtra.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //Toast.makeText(applicationContext, "Volviendo...Aja", Toast.LENGTH_SHORT).show();
                onBackPressedDispatcher.onBackPressed()
            }
        })

        //Adaptar el recycler
        recyclerViewChat = findViewById(R.id.recyclerViewChat)
        recyclerViewChat.layoutManager = LinearLayoutManager(applicationContext)
        adapter = MessageAdapter(messageList)
        recyclerViewChat.adapter = adapter

        // Referenciar el EditText y el botón de enviar
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSend = findViewById(R.id.buttonSend)

        // Configurar el listener para el botón de enviar
        buttonSend.setOnClickListener {
            val messageText = editTextMessage.text.toString()
            if (messageText.isNotEmpty()) {
                // Agregar el mensaje del usuario actual
                val messageMe = Message(messageText, "Me", System.currentTimeMillis())
                messageList.add(messageMe)
                adapter.notifyItemInserted(messageList.size - 1)
                recyclerViewChat.scrollToPosition(messageList.size - 1)
                editTextMessage.text.clear()

                // Simular la respuesta del otro usuario automáticamente
                val messageOther = Message("Mensaje automático escribio esto ajajaj", "Otro usuario", System.currentTimeMillis() + 1000)
                messageList.add(messageOther)
                adapter.notifyItemInserted(messageList.size - 1)
                recyclerViewChat.scrollToPosition(messageList.size - 1)
            }
        }
    }
}