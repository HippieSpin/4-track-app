package com.example.a4_trackapp

import android.os.Looper

class Timer (listener: TimerListener) {

    interface TimerListener{
        fun timerTick(duration: Long)
    }

    private var handler = android.os.Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable
    private var duration = 0L
    private var delay = 100L

    init {
        runnable = Runnable {
            duration += delay
            handler.postDelayed(runnable,delay)
            listener.timerTick(duration)
        }
    }

    fun start() {
        handler.postDelayed(runnable,delay)
    }

    fun pause() {
        handler.removeCallbacks(runnable)
    }

    fun stop() {
        handler.removeCallbacks(runnable)
        duration = 0L
    }
}