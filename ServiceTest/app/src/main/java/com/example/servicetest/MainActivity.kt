package com.example.servicetest

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import com.example.servicetest.MyService

class MainActivity : AppCompatActivity() {



    lateinit var downloadBinder:MyService.DownloadBinder;
    var connection = object :ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
            downloadBinder = this.service;
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var startService =  findViewById<Button>(R.id.start_service)
        var stopService = findViewById<Button>(R.id.stop_service)
        startService.setOnClickListener {
            var startIntent : Intent = Intent(this, MyService::class.java)
            startService(startIntent);
        }
        stopService.setOnClickListener {
            var stopIntent :Intent = Intent(this, MyService::class.java);
            stopService(stopIntent);
        }


        var bindService =  findViewById<Button>(R.id.bind_service)
        var unbindService = findViewById<Button>(R.id.unbind_service)
        bindService.setOnClickListener {

        }
        unbindService.setOnClickListener {

        }
    }

//    override fun onClick(v: View){
//        when(v) {
//            startService -> {
//
//            }
//            stopService -> {
//
//            }
//        }
//    }
}