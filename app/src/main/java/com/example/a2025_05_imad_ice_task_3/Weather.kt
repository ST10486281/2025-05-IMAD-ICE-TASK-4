package com.example.a2025_05_imad_ice_task_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Weather : AppCompatActivity() {

    // Parallel arrays
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private var maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val weekDataTextView = findViewById<TextView>(R.id.weekDataTextView)
        val averageTempTextView = findViewById<TextView>(R.id.averageTempTextView)
        val backButton = findViewById<Button>(R.id.backButton)

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

        val editButton = findViewById<Button>(R.id.editButton)

        editButton.setOnClickListener {
            val intent = Intent(this, Edit::class.java)
            intent.putExtra("temps", maxTemps)
            startActivityForResult(intent, 1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        val weekDataTextView = findViewById<TextView>(R.id.weekDataTextView)
        val averageTempTextView = findViewById<TextView>(R.id.averageTempTextView)

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val newTemps = data.getIntArrayExtra("newTemps")
            if (newTemps != null) {
                maxTemps = newTemps.toTypedArray()

                // Recalculate everything again
                var allData = ""
                for (i in days.indices) {
                    allData += "${days[i]}: ${maxTemps[i]}°C\n"
                }
                weekDataTextView.text = allData

                val average = maxTemps.sum() / maxTemps.size
                averageTempTextView.text = "Average Temp: $average°C"
            }
        }
    }

}