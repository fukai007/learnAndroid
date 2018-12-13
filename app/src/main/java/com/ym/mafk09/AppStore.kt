package com.ym.mafk09

import android.app.Application
// 全局共享的数据-2018-12-09 21:56
public class AppStore: Application() {


    // 程序创建的时候执行
    override fun onCreate() {
        super.onCreate()
    }


    // 程序终止的时候执行
    override fun onTerminate() {
        super.onTerminate()
    }


    // 低内存的时候执行
    override fun onLowMemory() {
        super.onLowMemory()
    }


    // 程序在内存清理的时候执行
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }


    private  var appId2:Int = 100;
    var appId: Int
        get() = 693078
        set(value) = TODO()
}