package com.ym.mafk09.customBroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
//有序广播-2018-12-13 07:58
class LowSendOrderBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var actionName = intent?.action;
        var resultExtras  = getResultExtras(true);
        var content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG,"low action --is -->$actionName---${intent.getStringExtra("customBroadcastMsg")}---content---$content")
    }

    companion object {
        public  val TAG = "LowSendOrderBroadcast"
    }
}

