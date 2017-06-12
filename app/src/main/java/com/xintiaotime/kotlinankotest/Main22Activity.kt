package com.xintiaotime.kotlinankotest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick

class Main22Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lambda = {
            left : Int , right : Int -> left + right
        }
        verticalLayout {
            val text = textView("这是第二个activity"){
                textSize = 24f
            }.lparams{
                width = matchParent
            }
            val button = button("点击提示"){
                textSize = 24F
            }.lparams{
                width = wrapContent
                height = wrapContent
                gravity = 17
            }
            button.onClick {
                toast("${lambda(10,20)}")
            }
        }
    }


}
