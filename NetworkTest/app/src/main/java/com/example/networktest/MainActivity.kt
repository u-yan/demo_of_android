package com.example.networktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var responseText: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sendRequest: Button = findViewById(R.id.send_request)
        sendRequest.setOnClickListener{
            sendRequestWithHttpURLConnection();
        }

    }

    private fun sendRequestWithHttpURLConnection() {
//        val s:String = "?";
//        Thread(Runnable {
//            try {
//                val url: URL = URL("https://www.baidu.com/")
//                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
//                connection.requestMethod = "GET"
//                connection.connectTimeout = 8000
//                connection.readTimeout = 8000
//                Log.d(
//                    "TAgggG",
//                    "  " + connection.readTimeout.toString() + ", " + connection.connectTimeout.toString()
//                )
//                connection.connect()
//                var responseCode = connection.responseCode
//                Log.d("TAgggG", "responseCode$responseCode");
//                connection.disconnect()
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }).start()
        GlobalScope.async {
            try {
                Log.d("TAgggG", "cnt: ?")
                val url: URL = URL("http://10.0.2.2")
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                Log.d("TAgggG", "cnt: 1" + connection.readTimeout.toString() + connection.connectTimeout.toString())
                var responseCode = connection.responseCode
                Log.d("TAgggG", "responseCode$responseCode");
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    var line:String? = "";
                    var i_n:InputStream = connection.inputStream;
                    var reader:BufferedReader;
                    reader = BufferedReader(InputStreamReader(i_n));
                    var response:StringBuilder = StringBuilder();

                    while ( reader.readLine().also { line = it } != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());
                }
                connection.disconnect()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    private fun showResponse(response: String) {
        try {
            responseText = findViewById(R.id.response_text)
            responseText.setText(response.toString())
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

}