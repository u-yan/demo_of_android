package com.example.okhttpdemo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import org.xmlpull.v1.XmlPullParserException;
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var responseText: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sendRequest: Button = findViewById(R.id.send_request)
        sendRequest.setOnClickListener{
            sendRequestWithOKHttp();
        }
    }
    private fun sendRequestWithOKHttp() {
//        val s:String = "?";
        Thread(Runnable {
            try {
                Log.d("TAgggG", "cnt: ?")
                val url: URL = URL("http://10.0.2.2/get_data.xml")
                val client: OkHttpClient = OkHttpClient()
                var request : Request = Request.Builder()
                    .url(url)
                    .build()
                var response : Response = client.newCall(request).execute();
                var responseData : String = response.body.toString();
                parseXMLWithPull(responseData,response);
//                showResponse(responseData);

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }).start()
//        GlobalScope.async {
//
//        }

    }

    private fun parseXMLWithPull(xmlData: String, response:Response) {
        try {
            var factory : XmlPullParserFactory= XmlPullParserFactory.newInstance()
            var xmlPullParser = factory.newPullParser();
            Log.d("TAG???", xmlData)
            var i_n = ByteArrayInputStream(response.body?.bytes());
            xmlPullParser.setInput(i_n, "utf-8")
            var eventType = xmlPullParser.eventType;
            var id : String = ""
            var name : String = ""
            var version : String = ""
            while (eventType != XmlPullParser.END_DOCUMENT) {
                var nodename : String? = xmlPullParser.name;
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if ("id" == nodename) {
                            id = xmlPullParser.nextText()
                        } else if ("name" == nodename) {
                            name = xmlPullParser.nextText()
                        } else if ("version" == nodename) {
                            version = xmlPullParser.nextText()
                        }
                    }
                    XmlPullParser.END_TAG -> {
                        if ("app" == nodename) {
                            Log.d("TaaaAG", "id is " + id);
                            Log.d("TaaaAG", "name is " + name);
                            Log.d("TaaaAG", "version is " + version)
                        }
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }


//    private fun showResponse(response: String) {
//        try {
//            responseText = findViewById(R.id.response_text)
//            responseText.setText(response.toString())
//        }catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

}
