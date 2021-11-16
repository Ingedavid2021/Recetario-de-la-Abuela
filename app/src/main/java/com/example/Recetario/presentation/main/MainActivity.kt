package com.example.Recetario.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Recetario.R
import com.example.Recetario.presentation.adapters.RecipeAdapter
import com.example.Recetario.presentation.adapters.RecipeAdapterController
import com.example.Recetario.presentation.creation.CreationActivity
import com.example.Recetario.recipe.Recipe
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener, MainController.View,
    RecipeAdapterController {
    private lateinit var fbAdd: FloatingActionButton
    private lateinit var rvRecipes : RecyclerView
    private lateinit var presenter: MainPresenter
    private lateinit var adapterRecipes : RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,this)

        fbAdd = findViewById(R.id.fbAdd)
        fbAdd.setOnClickListener(this)

        rvRecipes = findViewById(R.id.rvRecipes)

        adapterRecipes = RecipeAdapter(mutableListOf(),this)
        rvRecipes.layoutManager = LinearLayoutManager(this)
        rvRecipes.setHasFixedSize(true)
        rvRecipes.adapter = adapterRecipes
    }

    override fun onResume() {
        super.onResume()
        presenter.getRecipes()
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.fbAdd ->{
                startActivity(Intent(this,CreationActivity::class.java))
            }
        }

    }

    override fun setRecipes(recipes: MutableList<Recipe>) {
        adapterRecipes.updateData(recipes)

    }

    override fun removeRecipe(recipe: Recipe) {
        presenter.deleteRecipe(recipe)

    }
}