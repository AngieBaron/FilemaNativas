package com.example.appcitas.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcitas.R
import com.example.appcitas.adapter.UserAdapter
import com.example.appcitas.model.UserProvider


class MatchAmistad : Fragment() {
    // se declaran variables para el RecyclerView y el adaptador de usuarios
        private lateinit var recyclerView: RecyclerView
        private lateinit var userAdapter: UserAdapter

        @SuppressLint("MissingInflatedId")
        // Método llamado al crear la vista del fragmento
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflar el diseño del fragmento
            val view = inflater.inflate(R.layout.fragment_match_amistad, container, false)

            // Obtener referencias al RecyclerView y crear un adaptador de usuarios
            recyclerView = view.findViewById(R.id.ViewUsers)
            userAdapter = UserAdapter(UserProvider.UsuariosList)

            // Configurar el LinearLayoutManager y el adaptador para el RecyclerView
            val layoutManager = LinearLayoutManager(requireContext())
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = userAdapter

            // Agregar un listener para detectar el desplazamiento en el RecyclerView
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    // Verificar si el desplazamiento ha terminado
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        // Obtener la posición del primer elemento visible
                        val currentPosition = layoutManager.findFirstVisibleItemPosition()
                        recyclerView.post {
                            // Calcular una posición de destino (actualmente no hace nada)
                            val targetPosition = calculateTargetPosition(currentPosition)
                            //Consume al metodo smoothScrollToPosition para realizar la animacion del scroll
                            recyclerView.smoothScrollToPosition(targetPosition)
                        }
                    }
                }
            })

            return view // Devolver la vista para ser mostrada en la pantalla
        }

    private fun calculateTargetPosition(currentPosition: Int): Int {
        //calcula la posicion del item
        return currentPosition
    }
}