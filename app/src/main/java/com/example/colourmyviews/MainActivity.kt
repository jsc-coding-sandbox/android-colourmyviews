package com.example.colourmyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colourmyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main) // Both of these are valid BTW
        setContentView(binding.root) // Both of these are valid BTW

        // Function to create the event listeners.
        setListeners()
    }

    private fun setListeners() {

        binding.apply {
            // Binding removes underscores and puts things in camelCase, hence "boxOne" instead
            // of "box_one".
            val clickableViews: List<View> =
                listOf(
                    boxOne, boxTwo, boxThree,
                    boxFour, boxFive
                )

            for (item in clickableViews) {
                item.setOnClickListener() { makeColoured(it) }
            }
        }
    }

    private fun makeColoured(view: View) {
        when (view.id) {
            // Example of Color class
            R.id.box_one -> view.setBackgroundColor(Color.GRAY)
            R.id.box_two -> view.setBackgroundColor(Color.DKGRAY)
            // Example of Android colour resources
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_green_light)
        }
    }
}