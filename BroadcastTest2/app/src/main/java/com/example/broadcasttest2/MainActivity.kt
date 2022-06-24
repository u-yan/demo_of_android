package com.example.broadcasttest2

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcasttest2.AnotherBroadcastReceiver
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intentFilter:IntentFilter = IntentFilter();
        intentFilter.apply {
            addAction("com.example.broadcasttest.MY_BROADCAST")
        }
        val myBroadcastReceiver : AnotherBroadcastReceiver = AnotherBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, intentFilter)
    }
}