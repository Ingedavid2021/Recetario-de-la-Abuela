package com.example.Recetario.presentation.main

import android.content.Context
import com.example.Recetario.recipe.Recipe
import com.example.Recetario.recipes.local.MyDataBase
import com.example.Recetario.recipes.newrecipes.NewRecipesEntity

class MainPresenter(val view: MainController.View, val context: Context): MainController.Presenter {

    private val database = MyDataBase.invoke(context)

    override fun getRecipes() {
        val recipes= database.newrecipesdao().getRecipes()


        view.setRecipes(recipes.map(NewRecipesEntity::convertToRecipe).toMutableList())


    }

    override fun deleteRecipe(recipe: Recipe) {
        database.newrecipesdao().delete(Recipe.toConvertEntity(recipe))
    }
}