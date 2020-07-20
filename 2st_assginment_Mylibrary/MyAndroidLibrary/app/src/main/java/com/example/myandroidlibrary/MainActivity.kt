package com.example.myandroidlibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageNum = 0
        var ranNum = 0
        val rnd = Random()

        fun randomImage(){
            while(ranNum == imageNum){
                ranNum = rnd.nextInt(5)
            }
            imageNum = ranNum
        }

        mainBtn.setOnClickListener {
            if (ranNum == 0){
                randomImage()
                imageView.setImageResource(R.drawable.seal)
            }
            else if(ranNum == 1){
                randomImage()
                imageView.setImageResource(R.drawable.dolphin)
            }
            else if(ranNum == 2){
                randomImage()
                imageView.setImageResource(R.drawable.seal2)
            }
            else if(ranNum == 3){
                randomImage()
                imageView.setImageResource(R.drawable.starfish)
            }
            else if(ranNum == 4){
                randomImage()
                imageView.setImageResource(R.drawable.sponge)
            }
        }

//        spinnerBtn.setOnClickListener {
//            val intent = Intent(this, Spinner::class.java)
//            startActivity(intent)
//        }
//
    }
}