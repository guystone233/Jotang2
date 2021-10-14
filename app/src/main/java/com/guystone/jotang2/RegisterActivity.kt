package com.guystone.jotang2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun onclick(view: View) {

        val username = findViewById<EditText>(R.id.editTextUserName)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val passwordagain = findViewById<EditText>(R.id.editTextTextPasswordAgain)
        val sex = findViewById<EditText>(R.id.editTextSex)
        val phonenum = findViewById<EditText>(R.id.editTextPhoneNumber)
        val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
        val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()

        if(prefs.getString(username.text.toString(),"") != "") {
            Toast.makeText(this, "User already exists!", Toast.LENGTH_SHORT).show()
            return
        }
        if(username.text.toString() == "") {
            Toast.makeText(this, "Please enter username!", Toast.LENGTH_SHORT).show()
            return
        }
        if(password.text.toString() == "") {
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show()
            return
        }
        if(password.text.toString() != passwordagain.text.toString()) {
            Toast.makeText(this, "Two passwords should be the same!", Toast.LENGTH_SHORT).show()
            return
        }
        if(sex.text.toString() == "") {
            Toast.makeText(this, "Please enter your sex!", Toast.LENGTH_SHORT).show()
            return
        }

        editor.putString(username.text.toString(),username.text.toString())
        editor.putString(username.text.toString()+"password",password.text.toString())
        editor.putString(username.text.toString()+"sex",sex.text.toString())
        if(phonenum.text!=null)editor.putString(username.text.toString()+"phonenumber",phonenum.text.toString())
        editor.apply()
        Toast.makeText(this, "Register complete", Toast.LENGTH_SHORT).show()
        finish()
    }
}