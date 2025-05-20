package com.example.a2025_05_imad_ice_task_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val weekDataTextView = findViewById<TextView>(R.id.weekDataTextView)
        val averageTempTextView = findViewById<TextView>(R.id.averageTempTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        // Parallel arrays
        val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)

        // Display each day and temperature
        var allData = ""
        for (i in days.indices) {
            allData += "${days[i]}: ${maxTemps[i]}°C\n"
        }
        weekDataTextView.text = allData

        // Calculate average
        var sum = 0
        for (temp in maxTemps) {
            sum += temp
        }
        val average = sum / maxTemps.size
        averageTempTextView.text = "Average Temp: $average°C"

        backButton.setOnClickListener {
            finish() // returns to MainActivity
            Log.d("WeatherActivity", "Returning to MainActivity")
        }

    }
}