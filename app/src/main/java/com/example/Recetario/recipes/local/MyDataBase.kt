package com.example.Recetario.recipes.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.Recetario.recipes.newrecipes.NewRecipesDao
import com.example.Recetario.recipes.newrecipes.NewRecipesEntity

@Database(
    entities = [NewRecipesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MyDataBase : RoomDatabase() {

    abstract fun newrecipesdao():NewRecipesDao

    companion object{
        @Volatile
        private var instance :MyDataBase? =null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance
            ?: synchronized(LOCK){
                instance ?: buildDatabase(context)
                    .also { database ->
                        instance = database
                    }
            }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context,MyDataBase::class.java,"mydatabase.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }


}