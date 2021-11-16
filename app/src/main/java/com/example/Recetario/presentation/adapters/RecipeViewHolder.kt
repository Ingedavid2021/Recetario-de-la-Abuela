package com.example.Recetario.presentation.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Recetario.R

class RecipeViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    val tvNombre = view.findViewById<TextView>(R.id.tvNombre)
    val tvPasos = view.findViewById<TextView>(R.id.tvPasos)
    val tvIngredientes = view.findViewById<TextView>(R.id.tvIngredientes)
    val tvTienpo = view.findViewById<TextView>(R.id.tvTiempo)


}