package com.github.alexradaev.iatemobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEditor = findViewById(R.id.inputEditor) as EditText
        val textView = findViewById(R.id.textView) as TextView

        val updateButton = findViewById(R.id.updateButton) as Button
        val mainButton = findViewById(R.id.mainButton) as Button

        updateButton.setOnClickListener {  }
        mainButton.setOnClickListener {  }
    }
}