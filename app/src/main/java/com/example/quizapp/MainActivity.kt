package com.example.quizapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "onCreate : $jsonText")

        val gson = Gson()
        val type = object : TypeToken<List<Question>>() {}.type
        val questions = gson.fromJson<List<Question>>(jsonText, type)
        Log.d(TAG, "onCreate : \n${questions.toString()}")

        quiz = Quiz(questions)

        a1.setOnClickListener {
            quiz.score(0)
            scoreText.text = "Score :" + quiz.giveScore()
            if(quiz.noMoreQuestions()) {

            }
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

    fun gameOver() {
        a1.visibility = View.GONE
        a2.visibility = View.GONE
        a3.visibility = View.GONE
        a4.visibility = View.GONE
        if(quiz.checkResults()) {
            qText.text =
        }
    }

}