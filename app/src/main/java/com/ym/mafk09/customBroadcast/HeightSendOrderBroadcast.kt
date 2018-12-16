package com.ym.mafk09.customBroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
//有序广播-2018-12-13 07:58-
class HeightSendOrderBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var actionName = intent?.action;
        // abortBroadcast(); // 终止向下传播
        var resultExtras  = getResultExtras(true);
        var content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG,"height action --is -->$actionName---${intent.getStringExtra("customBroadcastMsg")}--content--$content")
        resultExtras.putCharSequence("content","被高级组件修改过的值.................")
        // setResultExtras(resultExtras)  不写也可以的因为是根据指针修改的

    }

    companion object {
        public  val TAG = "HeightOrderBroadcast"
    }
}

