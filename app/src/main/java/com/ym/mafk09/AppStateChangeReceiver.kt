package com.ym.mafk09

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AppStateChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var actionName = intent?.action

        if(Intent.ACTION_PACKAGE_ADDED.equals(actionName)){
            Log.d(TAG,"应用安装了,他的相关信息是 ---> "+intent?.data)
        }else if( Intent.ACTION_PACKAGE_REMOVED.equals(actionName)){
            Log.d(TAG,"应用卸载了,他的相关信息是 ---> "+intent?.data)
        }
    }

    companion object {
        public val TAG = "BootCompleteReceiver"
    }

    
}