package com.example.uiwidgettest

class Fruit {
    private var name :String;
    private var imageid:Int;
    constructor(name:String, imageId:Int) {
        this.name = name;
        imageid = imageId
    }
    fun getName() :String {
        return name;
    }
    fun getImageId:Int() {
        return imageid
    }
}