package com.ym.mafk09.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ym.mafk09.R
import kotlinx.android.synthetic.main.custom_broadcast.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CustomBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_broadcast)

        sendMessageBtn.onClick {
            sendBroadcastMsg(sendMessageBtn)
        }
    }

    private fun sendBroadcastMsg(view:View){
        var msg = sendMessageByBroadcast.text.toString();
        var intent = Intent();
        intent.action = "com.ym.mafk09.action.sendMsg";
        intent.putExtra("customBroadcastMsg",msg);
        println("sendBroadcast action is ----------->${intent.action}--$msg")
        sendBroadcast(intent);
    }
}
