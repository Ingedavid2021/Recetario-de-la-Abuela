package com.example.Recetario.presentation.main

import com.example.Recetario.recipe.Recipe

interface MainController {
    interface View{
        fun setRecipes(recipes: MutableList<Recipe>)
    }

    interface Presenter{
        fun getRecipes()
        fun deleteRecipe(recipe: Recipe)

    }
}