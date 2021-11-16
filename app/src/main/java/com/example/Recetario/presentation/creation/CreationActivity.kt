package com.example.Recetario.presentation.creation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.Recetario.R
import com.example.Recetario.recipe.Recipe
import java.util.*

class CreationActivity : AppCompatActivity(), CreationController.View, View.OnClickListener {

    private lateinit var presenter : CreationPresenter
    private lateinit var btnSave : Button
    private lateinit var etName : EditText
    private lateinit var etSteps : EditText
    private lateinit var etIngredients : EditText
    private lateinit var etTime : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creation)

        presenter = CreationPresenter(this,this)


        btnSave = findViewById(R.id.btnSave)
        btnSave.setOnClickListener(this)

        etSteps = findViewById(R.id.etSteps)
        etIngredients = findViewById(R.id.etIngredients)
        etTime = findViewById(R.id.etTime)
        etName = findViewById(R.id.etName)
    }

    override fun success() {

    }

    override fun error(msg : String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }



    override fun onClick(view: View) {
        when (view.id){
            R.id.btnSave ->{

                val id = UUID.randomUUID().toString()

                val name = etName.text.toString()
                val steps = etSteps.text.toString()
                val ingredients = etIngredients.text.toString()
                val time = etTime.toString()


                val recipe = Recipe(name, steps,ingredients,time)
                presenter.createRecipe(recipe)

            }
        }

    }
}