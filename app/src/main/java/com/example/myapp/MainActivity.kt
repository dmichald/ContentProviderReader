package com.example.myapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        Log.d("C", "CLICK")
        val projection = arrayOf("number", "user_name")
        val contentUri: Uri =
            Uri.parse("content://com.example.exampleapp.provider/.contentprovider.ExampleContentProvider")

        val cursor = contentResolver.query(
            contentUri, projection, null, null,
            null
        )
        if (cursor?.moveToFirst() == true) {
            do {
                val layout = findViewById<View>(R.id.userList) as LinearLayout
                val et = TextView(this)
                et.text = "${cursor.getString(1)} | ${cursor.getString(0)}"
                layout.addView(et)
            } while (cursor.moveToNext())
        }
    }
}