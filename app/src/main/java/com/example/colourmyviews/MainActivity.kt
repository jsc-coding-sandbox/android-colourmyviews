package com.example.colourmyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colourmyviews.databinding.ActivityMainBinding
import kotlin.random.Random

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
                    boxFour, boxFive, constraintLayout,
                    redButton, blueButton, greenButton
                )

            for (item in clickableViews) {
                item.setOnClickListener { makeColoured(it) }
            }
        }
    }

    private fun makeColoured(view: View) {
        val randomNum = (0..4).random()
        val selectedView: View

        // Select a box to change at random for the bottom buttons.
        // Note: this also includes boxes that are already the selected colour.
        // (Yep I got bored following the tutorial exactly).
        selectedView = when (randomNum) {
            0 -> binding.boxOne
            1 -> binding.boxTwo
            2 -> binding.boxThree
            3 -> binding.boxFour
            4 -> binding.boxFive
            else -> binding.boxOne // Box one as default
        }

        // "when" is a Kotlin switch statement BTW
        when (view.id) {
            // Example of setting colour using Color class
            R.id.box_one -> view.setBackgroundColor(Color.GRAY)
            R.id.box_two -> view.setBackgroundColor(Color.DKGRAY)
            // Example of setting colour using Android or project's colour resources
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> selectedView.setBackgroundResource(R.color.my_red)
            R.id.blue_button -> selectedView.setBackgroundResource(R.color.my_blue)
            R.id.green_button -> selectedView.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY) // Something else was tapped, do background
        }
    }
}