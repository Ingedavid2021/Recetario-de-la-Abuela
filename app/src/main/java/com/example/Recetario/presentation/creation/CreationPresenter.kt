package com.example.Recetario.presentation.creation

import android.content.Context
import com.example.Recetario.recipe.Recipe
import com.example.Recetario.recipes.local.MyDataBase

class CreationPresenter (private val view: CreationController.View, private val context: Context): CreationController.Presenter {

    private val dataBase: MyDataBase = MyDataBase.invoke(context)
    override fun createRecipe(recipe:Recipe) {
        when {
            recipe.Nombre.isEmpty() -> {
                view.error("Por favor escribe un Nombre ")
            }
            recipe.Pasos.isEmpty() -> {
                view.error("Por favor escribe los pasos de la receta ")
            }
            recipe.Ingredientes.isEmpty() -> {
                view.error("Por favor escribe los ingredientes de la receta ")
            }
            recipe.Tiempo.isEmpty() -> {
                view.error("Por favor escribe el tiempo de la receta en horas ")
            }

            else -> {
                dataBase.newrecipesdao().insert(Recipe.toConvertEntity(recipe))
            }
        }

    }
}