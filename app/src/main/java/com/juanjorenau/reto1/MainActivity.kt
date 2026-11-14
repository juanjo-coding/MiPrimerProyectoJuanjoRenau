package com.juanjorenau.reto1

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://developer.android.com")

        val cbAndroid = findViewById<CheckBox>(R.id.cbAndroid)
        val cbReact = findViewById<CheckBox>(R.id.cbReact)
        val cbFlutter = findViewById<CheckBox>(R.id.cbFlutter)

        val checkListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                buttonView.setTypeface(null, Typeface.BOLD)
                buttonView.paintFlags = buttonView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            } else {
                buttonView.setTypeface(null, Typeface.NORMAL)
                buttonView.paintFlags = buttonView.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            }
        }

        cbAndroid.setOnCheckedChangeListener(checkListener)
        cbReact.setOnCheckedChangeListener(checkListener)
        cbFlutter.setOnCheckedChangeListener(checkListener)
    }
}
