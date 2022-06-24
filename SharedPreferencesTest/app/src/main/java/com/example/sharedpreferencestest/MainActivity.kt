package com.example.sharedpreferencestest

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button: Button = findViewById(R.id.save_data)
        button.setOnClickListener{
            var editor: SharedPreferences.Editor = getSharedPreferences("data", MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
            editor.apply()
        }
        val button1: Button = findViewById(R.id.restore_data)
        val TAG: String = ">>>>>>>>>>"
        button1.setOnClickListener{
            var pref: SharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
            val name: String? = pref.getString("name", "");
            val age: Int = pref.getInt("age", 0);
            val married: Boolean = pref.getBoolean("married", false);
            Log.d(TAG, "onCreate: " + name);
            Log.d(TAG, "onCreate: " + age.toString());
            Log.d(TAG, "onCreate: " + married.toString());
        }
    }
}