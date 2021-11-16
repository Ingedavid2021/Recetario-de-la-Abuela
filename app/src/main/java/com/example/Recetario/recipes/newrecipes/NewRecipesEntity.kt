package com.example.Recetario.recipes.newrecipes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.Recetario.recipe.Recipe

@Entity(tableName = "newrecipes")
data class NewRecipesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Nombre") var Nombre: String,
    @ColumnInfo(name = "Pasos") var Pasos: String,
    @ColumnInfo(name = "Ingredientes") var Ingredientes: String,
    @ColumnInfo(name = "Tiempo") var Tiempo: String,
){
    companion object{
        fun convertToRecipe(newRecipesEntity: NewRecipesEntity)=
            Recipe(
                newRecipesEntity.Nombre,
                newRecipesEntity.Ingredientes,
                newRecipesEntity.Pasos,
                newRecipesEntity.Tiempo,
            )
    }
}
