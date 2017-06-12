package com.xintiaotime.kotlinankotest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.__AdapterView_OnItemSelectedListener
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*
import kotlin.collections.ArrayList


class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var items = ArrayList<String>()
        for (i in 0 ..100){
            items.add("明天会更好")
        }
        relativeLayout{
            padding = dip(16)
            val list = listView(){
                adapter = ArrayAdapter<String>(this@Main2Activity,android.R.layout.simple_list_item_1,items)
                onItemClickListener = object :AdapterView.OnItemClickListener {
                    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        Toast.makeText(this@Main2Activity,"postion=$p2",Toast.LENGTH_SHORT).show()
                        when(p2){
                            5-> startActivity<Main22Activity>()
                        }
                    }

                }
            }.lparams{
                height = matchParent
            }

//            val textView = textView("Hello World！"){
//                textSize = 24F
//            }.lparams{
//                width = matchParent
//                gravity = 14
//                alignParentTop()
//            }
//            val button = button("点击变色"){
//                textSize = 20F
//            }.lparams {
//                alignParentBottom()
//                centerHorizontally()
////                below(textView)
//            }
//            button.onClick { startActivity<Main22Activity>() }
        }
    }
}
