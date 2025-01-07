package com.example.android_lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var progresTextView: TextView
    private lateinit var buttonOk: Button
    private lateinit var editTextNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        seekBar = findViewById<SeekBar>(R.id.seekBar)
        progresTextView = findViewById<TextView>(R.id.progresTextView)
        buttonOk = findViewById<Button>(R.id.button)
        editTextNumber = findViewById(R.id.editTextNumber)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progresTextView.text = "${progress} %"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        buttonOk.setOnClickListener { _ ->
            val intent = Intent(this, SecondActivity::class.java)
            if(progresTextView.text.isEmpty())
            {
                Toast.makeText(this, "Введите цену!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            intent.putExtra("Count_hour", editTextNumber.text.toString())
            intent.putExtra("Discount", seekBar.progress.toString())
            startActivity(intent)
        }
    }
}