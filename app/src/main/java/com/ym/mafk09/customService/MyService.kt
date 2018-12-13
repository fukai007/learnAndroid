package com.ym.mafk09.customService

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.lang.Thread.sleep

// 可以启动  停止  绑定 解除绑定
class MyService : Service() {
    var isServerRunning:Boolean = false
    var data:HashMap<String,String> = HashMap();

    // 只执行一次
    override fun onCreate() {
        println("miles_server---------onCreate is called------------->")
        isServerRunning = true;
        super.onCreate()
    }


    override fun onBind(intent: Intent): IBinder {
        println("miles_server---------onBind is called------------->")
        var fkBinder = FKBinder();
        fkBinder.setServer(this);
        return fkBinder
    }



    override fun onUnbind(intent: Intent?): Boolean {
        println("miles_server---------onUnbind is called------------->")
        return super.onUnbind(intent)
    }


    // 每次点击 startServer()方法 都会执行
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread{
            while (isServerRunning){
                val fkAge = intent?.getIntExtra("fkAge",0);
                println("miles_server from mainActivity is running-($isServerRunning)---intent.fk-age------>$fkAge--${this.data.get("fkData")}");
                sleep(2000)
            }
        }.start()

        return super.onStartCommand(intent, flags, startId)
    }

    /**
     *  1. 点击 stopServer 会 调用 onDestroy 方法
     */
    override fun onDestroy() {
        println("miles_server---------onDestroy is called------------->")
        isServerRunning = false;
        super.onDestroy()
        println("miles_server from mainActivity is Destroyed ...$isServerRunning.............................................");

    }

    fun setData(key: String, value: String) {
        this.data.set(key,value);
    }
}
