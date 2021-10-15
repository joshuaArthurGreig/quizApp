package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var a1 : Button
    lateinit var a2 : Button
    lateinit var a3 : Button
    lateinit var a4 : Button
    lateinit var qText : TextView
    lateinit var scoreText : TextView
    lateinit var quiz : Quiz
    lateinit var quizQs : List<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        val inputStream = resources.openRawResource(R.raw.questions)

    }
    }

    fun wireWidgets() {
        a1 = findViewById(R.id.button_main_a1)
        a2 = findViewById(R.id.button_main_a2)
        a3 = findViewById(R.id.button_main_a3)
        a4 = findViewById(R.id.button_main_a4)
        qText = findViewById(R.id.textView_main_questionText)
        scoreText = findViewById(R.id.textView_main_scoreTrack)
    }

}