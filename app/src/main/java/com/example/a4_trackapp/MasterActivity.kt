package com.example.a4_trackapp

import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import com.example.a4_trackapp.databinding.ActivityMasterBinding
import android.media.MediaRecorder
import android.view.View
import android.widget.Button


class MasterActivity : AppCompatActivity(), Timer.TimerListener {


    private lateinit var recorder: MediaRecorder
    private lateinit var binding: ActivityMasterBinding
    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timer = Timer(this)

        binding.recordButton.setOnClickListener{
            timer.start()
        }

    }

    override fun timerTick(duration: Long) {
        binding.waveformView.addAmplitude(recorder.maxAmplitude.toFloat())
    }

}
