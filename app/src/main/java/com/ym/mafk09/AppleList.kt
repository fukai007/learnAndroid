package com.ym.mafk09

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter

import kotlinx.android.synthetic.main.activity_apple_list.*
import kotlinx.android.synthetic.main.content_apple_list.*

class AppleList : AppCompatActivity() {
    private var al_adapter:ArrayAdapter<String> ?= null;
    private var simp_adapter:SimpleAdapter?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apple_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

         var dataList = listOf("苹果A","苹果B","苹果C","苹果D","苹果E","苹果F");

        //1、建立一个数据适配器
        al_adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList)
        simp_adapter = SimpleAdapter(
            this,
            this.getAppleList(),
            R.layout.apple_item,
            arrayOf<String>("appleItemPic","appleItemName"),
            intArrayOf(R.id.appleItemPic,R.id.appleItemName))

//      appleList.adapter  = al_adapter
        appleList.adapter = simp_adapter

    }

    private  fun getAppleList(): ArrayList<Map<String, Object>>? {
        var dataList:ArrayList<Map<String,Object>> ?= arrayListOf();
        for( i in 1..5){
            var item:HashMap<String,Object> = HashMap<String,Object>()
            item.put("appleItemPic",R.drawable.ic_cloud as Object);
            item.put("appleItemName","appleId--$i--item" as Object);
            dataList?.add(item);
        }

        return dataList
    }
}
