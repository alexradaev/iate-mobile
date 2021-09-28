package com.github.alexradaev.iatemobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.github.alexradaev.iatemobile.practices.one.NumbersExercise

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEditor = findViewById(R.id.inputEditor) as EditText
        val textView = findViewById(R.id.textView) as TextView

        val updateButton = findViewById(R.id.updateButton) as Button
        val mainButton = findViewById(R.id.mainButton) as Button

        val numsEx = NumbersExercise()
        textView.setText(numsEx.numbers.joinToString())

        updateButton.setOnClickListener {
            numsEx.updateNumbers()
            val numbers = numsEx.numbers
            textView.setText(numbers.joinToString())
        }
        mainButton.setOnClickListener {
            val text = inputEditor.text.toString()
            val number = text.toInt()
            numsEx.number = number
            val result = numsEx.listOfIndexes()
            val str = numsEx.numbers.joinToString() + "\n" + result.joinToString()
            textView.setText(str)
        }
    }
}