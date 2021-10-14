package com.guystone.jotang2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val textview = findViewById<TextView>(R.id.textView)
        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val usr = intent.getStringExtra("usr")
        textview.text ="Username:"+usr+"\n"+"Sex:"+prefs.getString(usr+"sex","")+"\n"+"Phone Number:"+prefs.getString(usr+"phonenumber","")
    }
}