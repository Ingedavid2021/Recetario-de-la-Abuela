package com.example.Recetario.presentation.creation

import com.example.Recetario.recipe.Recipe

interface CreationController {

    interface View {
        fun success()
        fun error(msg: String)


    }

    interface Presenter {
        fun createRecipe(recipe: Recipe)

    }
}