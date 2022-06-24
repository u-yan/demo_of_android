package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
     var intentFilter: IntentFilter? = null
     var networkChangeReceiver: NetworkChangeReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intentFilter = IntentFilter()
        intentFilter?.apply {
            addAction("android.net.conn.CONNECTIVITY_CHANGE")
        }
        networkChangeReceiver = NetworkChangeReceiver()
        registerReceiver(networkChangeReceiver, intentFilter)
        intentFilter = IntentFilter()

        intentFilter?.apply {
            addAction("com.example.broadcasttest.MY_BROADCAST")
        }
        val myBroadcastReceiver : MyBroadcastReceiver = MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, intentFilter)
        var button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            var intent: Intent = Intent("com.example.broadcasttest.MY_BROADCAST");
            sendBroadcast(intent);
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceiver);
    }
    class NetworkChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var connectivityManager: ConnectivityManager? =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?//这个方法基于context,只有
            var networkInfo : NetworkInfo? = connectivityManager?.activeNetworkInfo;
            if (networkInfo != null && networkInfo.isAvailable) {
                Toast.makeText(context, "network isAvailable", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "network isNotAvailable", Toast.LENGTH_SHORT).show()
            }
        }
    }
}