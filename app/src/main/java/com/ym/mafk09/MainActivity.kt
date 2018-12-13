package com.ym.mafk09

import android.content.*
import android.nfc.Tag
import android.os.BatteryManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity  () {
    internal lateinit var fkBinder: FKBinder
    private  var batteryLevelReceiver=BatteryLevelReceiver();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myConnection = MyConnection()

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        var text2:TextView = TextView(this);
        text2.text = "动态添加的"
        // setContentView(text2) 会覆盖搜索的UI组件-待解决-2018-12-09 21:53



        toPage2.onClick {
            // startActivity(Intent(this@MainActivity,m2t::class.java))
            // startActivity(Intent("com.ym.mafk09.intent.action.fromP1"))
            startActivity(Intent("com.ym.mafk09.intent.action.appleList"))
        }

        // 学习broadcast功能
        initBroadcastForBatteryChange();

        // 学习server功能
        initServerModule(myConnection)


        var appStore =  applicationContext as AppStore
        println("appStore.applicationContext------------------------------->"+appStore.appId)


    }

    /*
    * @purpose 学习server组件
    * @createTIme 2018-12-12 17:23
    * @author miles_fk
    * */
    private fun initServerModule(myConnection: MyConnection) {
        var serverIntent = Intent(this@MainActivity, MyService::class.java)
        // fk-age 是一个无效的key 无法拿到值-2018-12-11 08:23
        serverIntent.putExtra("fkAge", 30)

        startServerBtn.onClick {
            startService(serverIntent);
        }

        stopServerBtn.onClick {
            toast("尝试停止服务" + stopService(serverIntent))
        }

        bindServerBtn.onClick {
            bindService(serverIntent, myConnection, Context.BIND_AUTO_CREATE)
            toast("尝试绑定服务")
        }

        unBindServerBtn.onClick {
            unbindService(myConnection)
            toast("尝试绑定服务")
        }

        syncData.onClick {
            fkBinder.setData("fkData","fkData--is--success !!!!!!!!!!!!!!!");
            toast("尝试同步数据ByServer")
        }
    }

    /**
     *  @purpose 监听电池变化的广播
     *  @createTime 2018-12-13 08:22
     *  @author miles_fk
     */
    private fun initBroadcastForBatteryChange(){
        // 动态注册:监听电池变化的广播
        var intentFilter:IntentFilter = IntentFilter();

        // 设置频道
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)


        // 注册广播
        this.registerReceiver(batteryLevelReceiver,intentFilter)
    }


    override fun onDestroy() {
        super.onDestroy()
        // 取消广播防止内存泄漏
        batteryLevelReceiver?.let{
            this.unregisterReceiver(batteryLevelReceiver)
        }
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        private val TAG = "MainActivity"
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    /**
     * internal 声明，在同一模块中的任何地方可见
     *  自定义ServiceConnection
     */

    internal inner class MyConnection : ServiceConnection {
        // 进程崩溃或者杀掉的时候
        override fun onServiceDisconnected(p0: ComponentName?) {

        }


        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            fkBinder = p1 as FKBinder//对象的强制转换
        }
    }

    /*
     * internal 声明，在同一模块中的任何地方可见
     * 第一步,创建一个广播接受者继承BroadcastReceiver
    */
    internal  inner class BatteryLevelReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            var action = intent?.action
            //Log.d(TAG,"收到电量变化的actions is == "+action);
            Log.d(TAG,"到电量变化的actions is == $action 当前电量是: ${intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)}");

        }

    }

}

