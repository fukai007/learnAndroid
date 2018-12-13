package com.ym.mafk09.ui

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.ym.mafk09.R

class m3t : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m3t)
        var m3tUri:Uri =  getIntent().data;
//        toast(m3tUri.path)
        println("m3tUriRaw----------------------->"+m3tUri)

    }

}
