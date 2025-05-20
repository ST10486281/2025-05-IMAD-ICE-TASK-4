package com.example.a2025_05_imad_ice_task_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)



        val incomingTemps = intent.getIntArrayExtra("temps") ?: intArrayOf()

        // Assume you have EditTexts like: mondayTempInput, tuesdayTempInput, etc.
        val tempInputs = arrayOf(
            findViewById<EditText>(R.id.mondayTempInput),
            findViewById<EditText>(R.id.tuesdayTempInput),
            findViewById<EditText>(R.id.wednesdayTempInput),
            findViewById<EditText>(R.id.thursdayTempInput),
            findViewById<EditText>(R.id.fridayTempInput),
            findViewById<EditText>(R.id.saturdayTempInput),
            findViewById<EditText>(R.id.sundayTempInput),
        )

        // Populate existing temps
        for (i in incomingTemps.indices) {
            tempInputs[i].setText(incomingTemps[i].toString())
        }

        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            val updatedTemps = IntArray(7)
            for (i in 0..6) {
                updatedTemps[i] = tempInputs[i].text.toString().toIntOrNull() ?: 0
            }

            val resultIntent = Intent()
            resultIntent.putExtra("newTemps", updatedTemps)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}