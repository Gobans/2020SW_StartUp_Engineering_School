package com.example.adaptorspiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageNum = 0


        mainBtn.setOnClickListener {
            if (imageNum == 0){
                imageNum = 1
                imageView.setImageResource(R.drawable.seal)
            }
            else{
                imageNum = 0
                imageView.setImageResource(R.drawable.Dolphin)
            }
        }

        spinnerBtn.setOnClickListener {
            val intent = Intent(this, Spinner::class.java)
            startActivity(intent)
            }

    }
}