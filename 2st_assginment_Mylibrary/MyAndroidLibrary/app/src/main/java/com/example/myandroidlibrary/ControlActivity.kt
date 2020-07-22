package com.example.myandroidlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_control.*
import java.util.*

class ControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        imageBtn.setOnClickListener {
            var season = seasonText.text.toString()
            if ( season == "봄" || season.toUpperCase(Locale.ROOT) == "SPRING"){
                imageView2.setImageResource(R.drawable.spring)}
            else if ( season == "여름" || season.toUpperCase(Locale.ROOT) == "SUMMER"){
                imageView2.setImageResource(R.drawable.summer)}
            else if ( season == "가을" || season.toUpperCase(Locale.ROOT) == "AUTUMN"){
                imageView2.setImageResource(R.drawable.autumn)}
            else if ( season == "겨울" || season.toUpperCase(Locale.ROOT) == "WINTER"){
                imageView2.setImageResource(R.drawable.winter)}
        }

        backBtn.setOnClickListener {
            finish()
        }

    }
}