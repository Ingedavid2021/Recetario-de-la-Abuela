package com.example.Recetario.recipes.newrecipes

import androidx.room.*

@Dao

interface NewRecipesDao {
    @Insert
    fun insert(recipes: NewRecipesEntity)

    @Update
    fun update(recipes: NewRecipesEntity)

    @Delete
    fun delete(recipes: NewRecipesEntity)

    @Query("select * from newrecipes")
    fun  getRecipes(): List<NewRecipesEntity>
}