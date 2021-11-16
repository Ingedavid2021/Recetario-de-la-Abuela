package com.example.Recetario.recipe

import com.example.Recetario.recipes.newrecipes.NewRecipesEntity

data class Recipe (
    var Nombre: String,
    var Pasos : String,
    var Ingredientes : String,
    var Tiempo: String,

        ){
    companion object{
        fun toConvertEntity(recipe: Recipe)=
            NewRecipesEntity(
                recipe.Nombre,
                recipe.Pasos,
                recipe.Ingredientes,
                recipe.Tiempo,

            )
    }
}