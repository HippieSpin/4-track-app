package com.example.a4_trackapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


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

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        rect.forEach {
            canvas?.drawRoundRect(it,radius,radius,paint)
        }
    }

    fun addAmplitude(amp: Float) {
        var amps = amplitudes.takeLast(maxRectangle)
        amplitudes.add(amp)

        rect.clear()
        for(i in amplitudes.indices) {
            var left = screenwidth - i*(w+d)
            var top  = 0f
            var right = left + w
            var bottom = amplitudes[i]
            rect.add(RectF(left, top, right, bottom))
        }
        invalidate()
    }
}