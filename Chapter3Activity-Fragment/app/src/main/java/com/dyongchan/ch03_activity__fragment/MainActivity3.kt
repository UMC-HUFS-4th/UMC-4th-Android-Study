package com.dyongchan.ch03_activity__fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dyongchan.ch03_activity__fragment.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val output = intent.getStringExtra("etinput")

        binding.tvMain3.text = output

    }
}