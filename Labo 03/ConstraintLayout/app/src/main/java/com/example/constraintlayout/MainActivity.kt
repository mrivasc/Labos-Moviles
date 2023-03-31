package com.example.constraintlayout

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    // Variables
    private lateinit var fiveCents : ImageView
    private lateinit var tenCents : ImageView
    private lateinit var quarter : ImageView
    private lateinit var dollar : ImageView

    private var moneyAmount : Double = 0.00
    private lateinit var moneyAmountTxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    private fun bind() {
        fiveCents = findViewById(R.id.fiveCents_img)
        tenCents = findViewById(R.id.tenCents_img)
        quarter = findViewById(R.id.quarter_img)
        dollar = findViewById(R.id.dollar_img)
        moneyAmountTxt = findViewById(R.id.moneyAmount_txt)
    }

    private fun addListener(){
        fiveCents.setOnClickListener {
            moneyAmount += 0.05
            moneyAmount = String.format("%.2f", moneyAmount).toDouble()
            moneyAmountTxt.text = "$${moneyAmount}"
        }

        tenCents.setOnClickListener {
            moneyAmount += 0.10
            moneyAmount = String.format("%.2f", moneyAmount).toDouble()
            moneyAmountTxt.text = "$${moneyAmount}"
        }

        quarter.setOnClickListener {
            moneyAmount += 0.25
            moneyAmount = String.format("%.2f", moneyAmount).toDouble()
            moneyAmountTxt.text = "$${moneyAmount}"
        }

        dollar.setOnClickListener {
            moneyAmount += 1.00
            moneyAmount = String.format("%.2f", moneyAmount).toDouble()
            moneyAmountTxt.text = "$${moneyAmount}"
        }
    }
}

