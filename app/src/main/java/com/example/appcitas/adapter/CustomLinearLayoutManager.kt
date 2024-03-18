package com.example.appcitas.adapter

import android.content.Context
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.appcitas.fragment.MatchAmistad

// Definición de una clase CustomLinearLayoutManager que extiende LinearLayoutManager
abstract class CustomLinearLayoutManager(context: Context, orientation: Int, reverseLayout: Boolean) :
    LinearLayoutManager(context, orientation, reverseLayout), Parcelable {


    // Sobrescribe el método smoothScrollToPosition para proporcionar un desplazamiento suave personalizado
    override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State?, position: Int) {
        // Crea una instancia de CustomSmoothScroller
        val smoothScroller = CustomSmoothScroller(recyclerView.context)
        // Configura la posición de destino del desplazamiento suave
        smoothScroller.targetPosition = position
        // Inicia el desplazamiento suave
        startSmoothScroll(smoothScroller)
    }

    // Clase interna que define un SmoothScroller personalizado
    private class CustomSmoothScroller(context: Context) : LinearSmoothScroller(context) {
        // Sobrescribe el método calculateSpeedPerPixel para definir la velocidad de desplazamiento por píxel
        override fun calculateSpeedPerPixel(displayMetrics: android.util.DisplayMetrics): Float {
            // Devuelve una velocidad constante de desplazamiento
            return 200f / displayMetrics.densityDpi
        }
    }
}