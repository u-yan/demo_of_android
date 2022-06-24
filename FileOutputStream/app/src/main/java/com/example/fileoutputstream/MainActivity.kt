package com.example.fileoutputstream

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import java.io.*
import java.lang.System.out

class MainActivity : AppCompatActivity() {
    private var edit: EditText? = null;
    private var TAG : String = ">>???????";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit = findViewById(R.id.edit)
        val inputText: String = load();
        if (!inputText.isNullOrEmpty()) {
            edit?.apply {
                setText(inputText);
                setSelection(inputText.length)
                Toast.makeText(context, "Restoring succeded", Toast.LENGTH_SHORT).show();
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        var inputText = edit?.text.toString()
        save(inputText)
    }
    private fun save(inputText: String) {
        var out: FileOutputStream? = null
        var writer: BufferedWriter? = null
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE)
            writer = BufferedWriter(OutputStreamWriter(out))
            writer.write(inputText)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                writer?.apply {
                    close();
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
    private fun load(): String {
        var i_n: FileInputStream? = null
        var reader: BufferedReader? = null
        var content: StringBuilder = java.lang.StringBuilder()
        try {
            i_n = openFileInput("data");
            reader = BufferedReader(InputStreamReader(i_n));
            var line: String? = ""
            line = reader.readLine();
            Log.d(TAG, "loasdd: ")
            while (line != null ) {
                content.append(line);
                Log.d(TAG, "loasdd: " + line);
                line = reader.readLine();
                if (line == null) {
                    Log.d(TAG, "load: ??????aaa???")
                    break;
                }
                if (line.isEmpty()) {
                    Log.d(TAG, "load: ?????nnn?aaa???")
                }
            }
            Log.d(TAG, "loasdd: " + line)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return content.toString()
    }

}