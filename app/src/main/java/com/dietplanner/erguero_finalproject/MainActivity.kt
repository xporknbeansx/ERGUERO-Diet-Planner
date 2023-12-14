package com.dietplanner.erguero_finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mealListView: ListView
    private lateinit var addMealButton: Button
    private val meals = mutableListOf<Meal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealListView = findViewById(R.id.mealListView)
        addMealButton = findViewById(R.id.addMealButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, meals.map { it.mealType })
        mealListView.adapter = adapter

        addMealButton.setOnClickListener {
            val intent = Intent(this, MealEntryActivity::class.java)
            startActivityForResult(intent, MEAL_ENTRY_REQUEST_CODE)
        }

        mealListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Handle meal item click here (e.g., display details)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MEAL_ENTRY_REQUEST_CODE && resultCode == RESULT_OK) {
            val meal = data?.getParcelableExtra<Meal>("meal")
            if (meal != null) {
                meals.add(meal)
                (mealListView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val MEAL_ENTRY_REQUEST_CODE = 1
    }
}
