package com.ym.mafk09

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG,"BootCompleteReceiver------------------>开机完成......")
    }

    companion object {
        public val TAG = "BootCompleteReceiver"
    }


}