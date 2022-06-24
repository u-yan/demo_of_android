package com.example.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    var TAG:String = "MyService"
    var mBinder : DownloadBinder = DownloadBinder();

    class DownloadBinder : Binder() {
        var TAG:String = "MyService"
        fun startDownload() {
            Log.d(TAG, "startDownload: ")
        }
        fun getProgress():Int{
            Log.d(TAG, "getProgress: ")
            return 0;
        }
    }
    override fun onBind(intent: Intent) : IBinder {
        return mBinder
    }
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

}