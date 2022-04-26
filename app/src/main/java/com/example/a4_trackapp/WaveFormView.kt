package com.example.a4_trackapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import java.lang.Math.*


class WaveFormView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var paint = Paint()
    private var amplitudes = ArrayList<Float>()
    private var rect = ArrayList<RectF>()
    private var radius = 6f
    private var w = 9f
    private var screenwidth = 0f
    private var sh = 400f
    private var d = 6f
    private var maxRectangle = 0

    init {
        paint.color = Color.rgb(244, 81, 30)
        screenwidth = resources.displayMetrics.widthPixels.toFloat()
        maxRectangle = (screenwidth / (w+d)).toInt()
    }


    fun addAmplitude(amp: Float) {
        var norm = (amp.toInt() / 7).coerceAtMost(400).toFloat()
        amplitudes.add(norm)

        rect.clear()
        var amps = amplitudes.takeLast(maxRectangle)
        for(i in amps.indices) {
            var left = screenwidth - i*(w+d)
            var top  = 0f
            var right = left + w
            var bottom = amps[i]
            rect.add(RectF(left, top, right, bottom))
        }
        invalidate()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        rect.forEach {
            canvas?.drawRoundRect(it,radius,radius,paint)
        }
    }
}