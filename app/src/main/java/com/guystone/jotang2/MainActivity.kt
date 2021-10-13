package com.guystone.jotang2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun reg(view: View) {
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
    fun gotofirst(){
        val intent = Intent(this,FirstActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun login(view: View) {
        val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
        val username = findViewById<EditText>(R.id.editTextUserName)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        if(username.text.toString() == "") {
            Toast.makeText(this, "Please enter username!", Toast.LENGTH_SHORT).show()
            return
        }
        if(password.text.toString() == "") {
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show()
            return
        }
        if(prefs.getString(username.text.toString()+"password",null)==password.text.toString()){
            Toast.makeText(this, "Login!", Toast.LENGTH_SHORT).show()
            gotofirst()
        }
        else Toast.makeText(this, "Username/Password may be wrong!", Toast.LENGTH_SHORT).show()
    }
}