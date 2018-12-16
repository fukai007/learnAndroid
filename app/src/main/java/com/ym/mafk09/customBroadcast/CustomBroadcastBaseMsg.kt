package com.ym.mafk09.customBroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
//无序广播-2018-12-13 07:58
class CustomBroadcastBaseMsg : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var actionName = intent?.action;
        Log.d(TAG,"action --is -->$actionName---${intent.getStringExtra("customBroadcastMsg")}")
    }

    companion object {
        public  val TAG = "CustomBroadcastBaseMsg"
    }
}

