package com.github.alexradaev.iatemobile.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.github.alexradaev.iatemobile.Helper
import com.github.alexradaev.iatemobile.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val rndText = intent.getStringExtra(Helper.RND_STRING)
        val textView = findViewById(R.id.textView2) as TextView
        textView.text = rndText

        val urlButton = findViewById(R.id.urlButton) as Button
        urlButton.setOnClickListener {
            val url = Uri.parse("http://www.iate.obninsk.ru")
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = url
            startActivity(urlIntent)
        }
    }
}