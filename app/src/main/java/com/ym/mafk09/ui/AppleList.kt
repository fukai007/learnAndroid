package com.ym.mafk09.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import com.ym.mafk09.R

import kotlinx.android.synthetic.main.activity_apple_list.*

class AppleList : AppCompatActivity() {
    private var al_adapter:ArrayAdapter<String> ?= null;
    private var simp_adapter:SimpleAdapter?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apple_list)

         var dataList = listOf("苹果A","苹果B","苹果C","苹果D","苹果E","苹果F");

        //1、建立一个数据适配器
        al_adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList)
        simp_adapter = SimpleAdapter(
            this,
            this.getAppleList(),
            R.layout.apple_item,
            arrayOf<String>("appleItemPic","appleItemName"),
            intArrayOf(R.id.appleItemPic, R.id.appleItemName))

//      appleList.adapter  = al_adapter
        appleList.adapter = simp_adapter

    }

    private  fun getAppleList(): ArrayList<Map<String, Any>>? {
        var dataList:ArrayList<Map<String,Any>> ?= arrayListOf();
        for( i in 1..5){
            var item:HashMap<String,Any> = HashMap<String,Any>()
            item.put("appleItemPic", R.drawable.ic_cloud as Any);
            item.put("appleItemName","appleId--$i--item" as Any);
            dataList?.add(item);
        }

        return dataList
    }
}
