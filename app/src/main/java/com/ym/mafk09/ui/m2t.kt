package com.ym.mafk09.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import com.ym.mafk09.R
import kotlinx.android.synthetic.main.activity_m2t.*
import org.jetbrains.anko.sdk27.coroutines.onFocusChange

class m2t : AppCompatActivity() {
    private var res = arrayListOf<String>("beijing01","beijing02","beijing03","beijing04","beijing05","beijing06");


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m2t);
//        actv01.onFocusChange { v, hasFocus ->  }

        /**
         *   - 增加一个适配器
         *   - 初始化数据
         *   - 绑定adapterList
         */
        var adapterList = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res)
        actv01.setAdapter(adapterList);

        /**
         *   - 增加一个适配器
         *   - 初始化数据
         *   - 绑定adapterList
         *   - 设置分隔符
         */
        mctv01.setAdapter(adapterList);
        mctv01.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}


