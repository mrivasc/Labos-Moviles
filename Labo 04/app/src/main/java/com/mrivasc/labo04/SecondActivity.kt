package com.mrivasc.labo04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var txtName : TextView
    private lateinit var txtEmail : TextView
    private lateinit var txtPhoneNumber : TextView
    private lateinit var shareButton : Button

    private var name = ""
    private var email = ""
    private var phoneNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity )

        bind()
        addListener()

        name = intent.getStringExtra("name").toString()
        email = intent.getStringExtra("email").toString()
        phoneNumber = intent.getStringExtra("phoneNumber").toString()

        txtName.text = "Name: $name"
        txtEmail.text = "Email: $email"
        txtPhoneNumber.text = "Phone Number: $phoneNumber"
    }

    private fun bind() {
        txtName = findViewById(R.id.txtName)
        txtEmail = findViewById(R.id.txtEmail)
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber)
        shareButton = findViewById(R.id.shareButton)
    }

    private fun addListener() {
        var name = intent.getStringExtra("name").toString()
        var email = intent.getStringExtra("email").toString()
        var phoneNumber = intent.getStringExtra("phoneNumber").toString()

        txtName.text = "Name: $name"
        txtEmail.text = "Email: $email"
        txtPhoneNumber.text = "Phone Number: $phoneNumber"

        var textToSend = "Name: $name \nEmail: $email \nPhone Number: $phoneNumber"
        shareButton.setOnClickListener {
            val share = Intent.createChooser(Intent().apply {
                type = "text/plain"
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, textToSend)
            }, null)
            startActivity(share)
        }
    }
}