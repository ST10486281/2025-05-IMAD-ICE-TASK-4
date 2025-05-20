package com.example.a2025_05_imad_ice_task_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)

        // Shows app info and navigates to WeatherActivity
        startButton.setOnClickListener {
            val intent = Intent(this, Weather::class.java)
            startActivity(intent)
            Log.d("MainActivity", "Navigating to WeatherActivity")
        }

    }
}