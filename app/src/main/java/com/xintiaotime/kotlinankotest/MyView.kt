package com.xintiaotime.kotlinankotest

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by MyPC on 2017/6/20.
 */

class MyView : View {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = getMySize(100, widthMeasureSpec)
        var height = getMySize(100, heightMeasureSpec)
        if (width < height){
            height = width
        }else{
            width = height
        }
        setMeasuredDimension(width,height)
//        Log.i("TAG","widthModel$widthModel")
//        Log.i("TAG","widthSize$widthSize")

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val measuredWidth = measuredWidth / 2
        val x = left + measuredWidth
        val y = top + measuredWidth
        var paint = Paint()
        var paint2 = Paint()
        var paint3 = Paint()
        var paint4 = Paint()
        paint.color = Color.parseColor("#999999")
        paint2.color = Color.parseColor("#ff0000")
        paint3.color = Color.parseColor("#00ff00")
        paint4.color = Color.parseColor("#0000ff")
        paint4.textSize = 60.toFloat()
        var str = "天气不错，/n/t心情不好"
//        canvas!!.drawCircle(x.toFloat(),y.toFloat(),measuredWidth.toFloat(),paint)
        canvas!!.drawText(str,0,str.length,0.toFloat(),top.toFloat()+measuredWidth/8,paint4)
//        canvas!!.drawArc(left.toFloat(),top.toFloat(),right.toFloat(),bottom.toFloat(),0.toFloat(),90.toFloat(),true,paint)
//        canvas!!.drawArc(left.toFloat(),top.toFloat(),right.toFloat(),bottom.toFloat(),90.toFloat(),90.toFloat(),true,paint2)
//        canvas!!.drawArc(left.toFloat(),top.toFloat(),right.toFloat(),bottom.toFloat(),180.toFloat(),90.toFloat(),true,paint3)
//        canvas!!.drawArc(left.toFloat(),top.toFloat(),right.toFloat(),bottom.toFloat(),270.toFloat(),90.toFloat(),true,paint4)
    }
    private fun getMySize(defaultSize: Int, measureSpec: Int) : Int{
        var mySize = defaultSize
        val widthModel = MeasureSpec.getMode(measureSpec)
        val widthSize = MeasureSpec.getSize(measureSpec)
        when(widthModel) {
            View.MeasureSpec.UNSPECIFIED -> {
                mySize = defaultSize
            }
            View.MeasureSpec.AT_MOST -> {
                mySize = widthSize
            }
            View.MeasureSpec.EXACTLY -> {
                mySize = widthSize
            }
        }
            return mySize
        }
    }
