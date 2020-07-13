package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log
import android.util.Log;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var plus_op = false
        var minus_op = false
        var divide_op = false
        var multiple_op = false
        var temp = 0
        /*
    숫자 버튼을 클릭하면 화면에 표시가된다 (0은 숫자가 0인상태에서 눌러도 반응하지 않는다)
    1 + 2 = 을하면 3이 표시된다
    1 + 2 + 을하면 화면에 중간과정의 값인 3이 표시되며  그 후 3 = 을 누르면 6이 표시된다
    사칙연산으로 확장한다
     */

        val btnOnClickListener = View.OnClickListener {
            when (it.id) {
                AC.id -> {
                    textView.setText("0");
                    var plus_op = false
                    var minus_op = false
                    var divide_op = false
                    var multiple_op = false
                }
                zero.id -> {
                    var sld = textView.getText().toString()
                    if (sld.equals("0")){;}else{
                        sld += '0'
                        textView.text = sld
                    }
                }
                one.id -> {
                    var sld = textView.getText().toString()
                    if (sld.equals("0")){
                        sld = ""
                    }
                    sld += '1'
                    textView.text = sld
                }
                two.id -> {
                    var sld = textView.getText().toString()
                    if (sld.equals("0")){
                        sld = ""
                    }
                    sld += '1'
                    textView.text = sld
                }

            }
        }

        fun process(){
            if (plus_op == true){
                val sld = textView.getText().toString()
                temp += Integer.parseInt(sld)
                textView.setText(temp.toString())
                plus_op = false
            }

        }

        val btnOperatorListener = View.OnClickListener {
            when (it.id){
                plus.id ->{
                    val sld = textView.getText().toString()
                    if (plus_op == true){
                        temp += Integer.parseInt(sld)
                        textView.setText(temp.toString())
                    }
                    plus_op = true

                    temp = Integer.parseInt(sld)
                    textView.text = "0"
                }
                equal.id ->{
                    process()
                }
            }
        }



        AC.setOnClickListener(btnOnClickListener)
        plus.setOnClickListener(btnOperatorListener)
        zero.setOnClickListener(btnOnClickListener)
        one.setOnClickListener(btnOnClickListener)
    }
}