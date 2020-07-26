package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        Back.setOnClickListener {
            finish()
        }
    }



    override fun onStart(){
        super.onStart()
        Log.d("LifeCycle","onStart : 액티비티의 시작, 이 때 화면이 그려짐")
    }

    override fun onResume(){
        super.onResume()
        Log.d("LifeCycle","onStart : 액티비티가 실행되고 있는 상태")
    }

    override fun onPause(){
        super.onPause()
        Log.d("LifeCycle","onStart : 액티비티가 일시정지. 조금이라도 다른 액티비티에 가려짐")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle","onStart : 액티비티가 사용자에게 표시되지않으면 발생")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle","onDestroy : 액티비티가 사라지기 전에 발생 ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle","onStart : 새로 시작될 때")
    }

}