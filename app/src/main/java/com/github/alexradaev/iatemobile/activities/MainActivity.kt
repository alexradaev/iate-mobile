package com.github.alexradaev.iatemobile.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.github.alexradaev.iatemobile.Helper
import com.github.alexradaev.iatemobile.R
import com.github.alexradaev.iatemobile.practices.one.Exercise
import com.github.alexradaev.iatemobile.practices.one.NumbersExercise
import com.github.alexradaev.iatemobile.practices.one.StringsExercise

class MainActivity : AppCompatActivity() {
    var exercise: Exercise = NumbersExercise()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEditor = findViewById(R.id.inputEditor) as EditText
        val textView = findViewById(R.id.textView) as TextView

        val updateButton = findViewById(R.id.updateButton) as Button
        val mainButton = findViewById(R.id.mainButton) as Button

        exercise = NumbersExercise()
        textView.setText(exercise.inputData)

        updateButton.setOnClickListener {
            val numbersExercise = exercise as NumbersExercise
            numbersExercise.updateNumbers()
            val numbers = numbersExercise.numbers
            textView.setText(numbers.joinToString())
        }
        mainButton.setOnClickListener {
            if (!inputEditor.text.isEmpty()) {
                val text = inputEditor.text.toString()
                val number = text.toInt()
                exercise.number = number
            }
            val result = exercise.result
            val str = exercise.inputData + "\n" + result
            textView.setText(str)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_numbers -> {
                numbersExercise()
                true
            }
            R.id.action_strings -> {
                stringsExercise()
                true
            }
            R.id.action_second_activity -> {
                startSecondActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun stringsExercise(){
        val inputEditor = findViewById(R.id.inputEditor) as EditText
        val updateButton = findViewById(R.id.updateButton) as Button

        exercise = StringsExercise()
        val textView = findViewById(R.id.textView) as TextView
        textView.setText(exercise.inputData)

        inputEditor.visibility = View.GONE
        inputEditor.inputType = InputType.TYPE_CLASS_TEXT
        updateButton.visibility = View.GONE
    }

    fun numbersExercise(){
        val inputEditor = findViewById(R.id.inputEditor) as EditText
        val updateButton = findViewById(R.id.updateButton) as Button

        exercise = NumbersExercise()
        val textView = findViewById(R.id.textView) as TextView
        textView.setText(exercise.inputData)

        inputEditor.visibility = View.VISIBLE
        inputEditor.inputType = InputType.TYPE_CLASS_NUMBER
        updateButton.visibility = View.VISIBLE
    }

    fun startSecondActivity(){
        val textView = findViewById(R.id.textView) as TextView
        val text = textView.text.toString()
        val sIntent = Intent(this, SecondActivity::class.java)
        sIntent.putExtra(Helper.RND_STRING, text)
        startActivity(sIntent)
    }
}