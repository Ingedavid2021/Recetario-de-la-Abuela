package com.example.Recetario.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Recetario.R
import com.example.Recetario.recipe.Recipe

class RecipeAdapter(var recipes:MutableList<Recipe>, val controller: RecipeAdapterController) :RecyclerView.Adapter<RecipeViewHolder>(){

    fun updateData(recipes: MutableList<Recipe>){
        this.recipes= recipes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_recipes,parent,false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
       val recipe = recipes[position]

        holder.tvNombre.text = recipe.Nombre
        holder.tvPasos.text = recipe.Pasos
        holder.tvIngredientes.text = recipe.Ingredientes
        holder.tvTienpo.text = recipe.Tiempo


        holder.itemView.setOnLongClickListener{
            controller.removeRecipe(recipe)
            true
        }
    }

    override fun getItemCount(): Int= recipes.size
}