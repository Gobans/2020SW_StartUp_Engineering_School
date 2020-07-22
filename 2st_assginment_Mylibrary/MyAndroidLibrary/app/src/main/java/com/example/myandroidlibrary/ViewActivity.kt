package com.example.myandroidlibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_control.*
import kotlinx.android.synthetic.main.activity_control.backBtn
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        backBtn.setOnClickListener {
            finish()
        }

        val onClickListener = View.OnClickListener {
            when (it.id) {
                layoutBtn.id -> {
                    val intent = Intent(this, LayoutActivity::class.java)
                    startActivity(intent)
                }

                widgetBtn.id -> {
                    val intent = Intent(this, WidgetActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        layoutBtn.setOnClickListener(onClickListener)
        widgetBtn.setOnClickListener(onClickListener)
    }
}