package com.mrivasc.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var inputName : TextInputLayout
    private lateinit var inputEmail : TextInputLayout
    private lateinit var inputPhoneNumber : TextInputLayout
    private lateinit var sendButton : Button

    private var name = ""
    private var email = ""
    private var phoneNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind() {
        inputName = findViewById(R.id.inputName)
        inputEmail = findViewById(R.id.inputEmail)
        inputPhoneNumber = findViewById(R.id.inputPhoneNumber)
        sendButton = findViewById(R.id.sendButton)
    }

    private fun addListener() {
        sendButton.setOnClickListener {
            name = inputName.editText?.text.toString()
            email = inputEmail.editText?.text.toString()
            phoneNumber = inputPhoneNumber.editText?.text.toString()

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("phoneNumber", phoneNumber)
            startActivity(intent)
        }
    }
}