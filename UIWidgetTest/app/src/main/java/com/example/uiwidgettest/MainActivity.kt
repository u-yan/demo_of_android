package com.example.uiwidgettest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
//    private var titleList :MutableList<String> =  ArrayList();
    private lateinit var adapter:ArrayAdapter<String>;
    private var list = mutableListOf<String>("数据1","数据2","数据1","数据1","数据1","数据1","数据1","数据1","数据1","数据1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("????", "create: ")
//        initList()
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        Log.d("????", "adapter: ")

        adapter.addAll(list)
        Log.d("????", "addall: ")
        val listView :ListView = findViewById(R.id.list_view)
        listView.adapter = adapter
        Log.d("????", "成功: ")
    }
//    fun initList() {
//        var i:Int = 0;
//        list = mutableListOf<String>()
//        while (i < 10) {
//            i ++
//            Log.d("????", "inittitleList: " + i.toString())
//            list.add(i.toString())
//        }
//    }
//    class TitleAdapter: ArrayAdapter<TitleLayout> {
//        private var resourceId :Int
//        constructor(context: Context, textViewResourceId: Int, objects: MutableList<String>) :super(context, textViewResourceId,objects){
//            resourceId = textViewResourceId;
//        }
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
////            var title: TitleLayout? =getItem(position)
////            val convertView =  LayoutInflater.from(context).inflate(resourceId, parent, false) ;
//            return convertView?:LayoutInflater.from(context).inflate(resourceId, parent, false)
//        }
//    }
}



