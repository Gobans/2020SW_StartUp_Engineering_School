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


        var operator_used = false// 연산하는 중이면 true 안하면 false
        var temp = 0.0 // 연산할 값 저장
        var result = 0.0 // 연산 최종 값 저장
        var oper_num = 0 //oper_num =1 : plus , 2 = minus ,3 = divide, 4= remainder, 5: equal
        var oper_continue = false // 연속으로 연산자 입력

        /*
    숫자 버튼을 클릭하면 화면에 표시가된다 (0은 숫자가 0인상태에서 눌러도 반응하지 않는다)
    1 + 2 = 을하면 3이 표시된다
    1 + 2 + 을하면 화면에 중간과정의 값인 3이 표시되며  그 후 3 = 을 누르면 6이 표시된다
    사칙연산으로 확장한다
     */
        fun typingNumber(number:Int){
            var sld = textView.getText().toString()
            if (sld.equals("0")){
                textView.text = number.toString()
                operator_used = false
            }
            else if(operator_used){
                textView.text = number.toString()
                operator_used = false
            }
            else{
                operator_used = false
                sld += number.toString()
                textView.text = sld
            }
        }

        fun saveNumber(){
            val sld = textView.text.toString()
            temp = sld.toDouble()
            operator_used = true
        }

        fun operation(){
            if (oper_num ==1){
                if (oper_continue){
                    result += temp
                    textView.text = result.toString()
                }else{
                    result += temp
                    textView.text = "0"
                    oper_continue = true
                }
            }
            else if(oper_num ==2){
                if (oper_continue){
                    result -= temp
                    textView.text = result.toString()
                }else{
                    result += temp
                    textView.text = "0"
                    oper_continue = true
                }
            }
            else if(oper_num ==3){
                if (oper_continue){
                    result /= temp
                    textView.text = result.toString()
                }else{
                    result += temp
                    textView.text = "0"
                    oper_continue = true
                }
            }
            else if(oper_num ==4){
                if (oper_continue){
                    result %= temp
                    textView.text = result.toString()
                }else{
                    result += temp
                    textView.text = "0"
                    oper_continue = true
                }
            }


        }


        val btnOnClickListener = View.OnClickListener {
            when (it.id) {
                AC.id -> {
                    oper_num = 0
                    temp = 0.0
                    textView.setText("0")
                    result = 0.0
                    operator_used = false
                    oper_continue = false
                }
                zero.id -> {typingNumber(0)}
                one.id -> {typingNumber(1)}
                two.id -> {typingNumber(2)}
                three.id -> {typingNumber(3)}
                four.id -> {typingNumber(4)}
                five.id -> {typingNumber(5)}
                six.id -> {typingNumber(6)}
                seven.id -> {typingNumber(7)}
                eight.id -> {typingNumber(8)}
                nine.id -> {typingNumber(9)}
                plus.id -> {
                    saveNumber()
                    oper_num =1
                    operation()
                }
                minus.id ->{
                    saveNumber()
                    oper_num = 2
                    operation()
                }
                division.id ->{
                    saveNumber()
                    oper_num = 3
                    operation()
                }
                remainder.id ->{
                    saveNumber()
                    oper_num = 4
                    operation()
                }

                equal.id -> {
                    saveNumber()
                    operation()
                    temp = 0.0
                    result = 0.0
                    operator_used = false
                    oper_continue = false
                }
            }
        }

        AC.setOnClickListener(btnOnClickListener)
        zero.setOnClickListener(btnOnClickListener)
        one.setOnClickListener(btnOnClickListener)
        two.setOnClickListener(btnOnClickListener)
        three.setOnClickListener(btnOnClickListener)
        four.setOnClickListener(btnOnClickListener)
        five.setOnClickListener(btnOnClickListener)
        six.setOnClickListener(btnOnClickListener)
        seven.setOnClickListener(btnOnClickListener)
        eight.setOnClickListener(btnOnClickListener)
        nine.setOnClickListener(btnOnClickListener)
        plus.setOnClickListener(btnOnClickListener)
        minus.setOnClickListener(btnOnClickListener)
        division.setOnClickListener(btnOnClickListener)
        remainder.setOnClickListener(btnOnClickListener)
        equal.setOnClickListener(btnOnClickListener)
    }
}