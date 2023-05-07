package com.dev.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.activity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewbinding :ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
    }
}