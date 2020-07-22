package com.example.myandroidlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_control.*

class TextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl("https://github.com/Gobans")

        backBtn.setOnClickListener {
            finish()
        }
    }
}