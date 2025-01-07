package com.example.android_lab5

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)

        text = findViewById(R.id.textView4)

        var count = intent.getStringExtra("Count_hour")
        var discount = intent.getStringExtra("Discount")

        var price = count.toString().toInt() * 2000
        var resultPrice = price - (price * discount.toString().toDouble() / 100.0)

        text.setText("Цена с учетом скидки = ${resultPrice} руб")
    }
}