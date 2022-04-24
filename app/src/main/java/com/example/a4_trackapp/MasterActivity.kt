package com.example.a4_trackapp

import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import com.example.a4_trackapp.databinding.ActivityMasterBinding
import android.media.MediaRecorder


class MasterActivity : AppCompatActivity() {

    private lateinit var recorder: MediaRecorder

    private lateinit var binding: ActivityMasterBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recordButton.setOnClickListener {
            timer()
        }
    }

    private fun timer() {
        binding.waveformView.addAmplitude(recorder.maxAmplitude.toFloat())
    }

}
