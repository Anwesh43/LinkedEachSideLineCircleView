package com.anwesh.uiprojects.eachsidelinecircleview

/**
 * Created by anweshmishra on 09/05/19.
 */

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.view.MotionEvent
import android.view.View

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.05f
val scDiv : Double = 0.51
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")
val rFactor : Float = 3.7f

fun Int.inverse() : Float = 1f / this
fun Float.scaleFactor() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.mirrorValue(a : Int, b : Int) : Float {
    val k : Float = scaleFactor()
    return (1 - k) * a.inverse() + k * b.inverse()
}
fun Float.updateValue(dir : Float, a : Int, b : Int) : Float = mirrorValue(a, b) * dir * scGap

fun Canvas.drawEachSideLine(i : Int, size : Float, sc : Float, paint : Paint) {
    val r : Float = size / rFactor
    val y : Float = -size * sc.divideScale(i, lines)
    save()
    translate(-size + i * 2 * size, -size)
    drawLine(0f, 0f, 0f, -size, paint)
    drawLine(0f, -size, 0f, -size + y, paint)
    drawCircle(0f, y, r * sc, paint)
    restore()
}

fun Canvas.drawESLCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    paint.color = foreColor
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.strokeCap = Paint.Cap.ROUND
    save()
    translate(w / 2, gap * (i + 1))
    rotate(90f * sc2 * (1f - 2 * i))
    for (j in 0..(lines - 1)) {
        drawEachSideLine(j, size, sc1, paint)
    }
    restore()
}

class EachSideLineCircleView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    
    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}