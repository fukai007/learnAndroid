package com.ym.mafk09.customBroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CustomBroadcastBaseMsg : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var actionName = intent?.action;
        Log.d(TAG,"action --is -->$actionName---${intent.getIntExtra("customBroadcastMsg",0)}")
    }
    companion object {
        public  val TAG = "CustomBroadcastBaseMsg"
    }
}

