package com.example.uiwidgettest

import android.content.AttributionSource
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout


class TitleLayout  : LinearLayout {
    constructor(context: Context):super(context) {
        TitleLayout(context, null);
    }
    constructor(context: Context, attrs: AttributeSet?):super(context, attrs) {
        LayoutInflater.from(context).inflate(R.layout.title, this)
        var title_back: Button = findViewById(R.id.title_back)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout)
        val title_back_content : String? = typedArray.getString(R.styleable.TitleLayout_back);
        title_back.setText(title_back_content)
    }
    constructor(context: Context, s1:String):super(context) {
        TitleLayout(context, null);
        val title_back: Button = findViewById(R.id.title_back)
        title_back.setText(s1)
    }
}