package com.example.labo02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var input = findViewById<EditText>(R.id.input)
        var button = findViewById<Button>(R.id.btn_saludar)
        var message = findViewById<TextView>(R.id.message)

        button.setOnClickListener {
            var messageToShow = input.text.toString()
            message.text = "Saludar a $messageToShow"
        }
    }
}