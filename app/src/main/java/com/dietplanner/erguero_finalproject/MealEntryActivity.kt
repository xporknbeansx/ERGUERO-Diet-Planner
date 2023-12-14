package com.dietplanner.erguero_finalproject

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MealEntryActivity : AppCompatActivity() {

    private lateinit var mealTypeEditText: EditText
    private lateinit var ingredientsEditText: EditText
    private lateinit var nutritionalValuesEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var mealListView: ListView

    private val meals = ArrayList<String>() // List to store meal information as strings
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_entry)

        mealTypeEditText = findViewById(R.id.mealTypeEditText)
        ingredientsEditText = findViewById(R.id.ingredientsEditText)
        nutritionalValuesEditText = findViewById(R.id.nutritionalValuesEditText)
        saveButton = findViewById(R.id.saveButton)
        mealListView = findViewById(R.id.mealListView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, meals)
        mealListView.adapter = adapter

        saveButton.setOnClickListener {
            val mealType = mealTypeEditText.text.toString()
            val ingredients = ingredientsEditText.text.toString()
            val nutritionalValues = nutritionalValuesEditText.text.toString()

            if (mealType.isNotEmpty() && ingredients.isNotEmpty() && nutritionalValues.isNotEmpty()) {
                val mealInfo = "Meal Type: $mealType\nIngredients: $ingredients\nNutritional Values: $nutritionalValues"
                meals.add(mealInfo)
                adapter.notifyDataSetChanged()

                // Clear EditText fields
                mealTypeEditText.text.clear()
                ingredientsEditText.text.clear()
                nutritionalValuesEditText.text.clear()
            }
        }
    }
}
