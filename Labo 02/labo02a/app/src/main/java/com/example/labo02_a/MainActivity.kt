package com.example.labo02_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var weight_input = findViewById<EditText>(R.id.weight_input)
        var height_input = findViewById<EditText>(R.id.height_input)
        var calculate_button = findViewById<Button>(R.id.btn_calculate)
        var showBMI = findViewById<TextView>(R.id.show_bmi)
        var weight_class_txt = findViewById<TextView>(R.id.txt_weight_class)
        var sub_text = findViewById<TextView>(R.id.sub_text)

        calculate_button.setOnClickListener{
            var weight = weight_input.text.toString().toDouble()
            var height = height_input.text.toString().toDouble()

            var bmi = (weight / ((height/100).pow(2)))
            bmi = ((bmi*100.0).roundToInt())/100.0

            var color = 0

            if (bmi < 18.5 ) {
                weight_class_txt.text = "Underweight"
                color = R.color.under_weight
                weight_class_txt.setTextColor(ContextCompat.getColor(this, color))
            } else if (bmi in 18.5 .. 24.99) {
                weight_class_txt.text = "Healthy"
                color = R.color.healthy
                weight_class_txt.setTextColor(ContextCompat.getColor(this, color))
            } else if (bmi in 25.0 .. 29.99) {
                weight_class_txt.text = "Overweight"
                color = R.color.overweight
                weight_class_txt.setTextColor(ContextCompat.getColor(this, color))
            } else {
                weight_class_txt.text = "Obese"
                color = R.color.obese
                weight_class_txt.setTextColor(ContextCompat.getColor(this, color))
            }
            sub_text.text = "(Normal range is 18.5 - 24)"
            showBMI.text = bmi.toString()
        }
    }
}