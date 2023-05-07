package com.dev.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.activity.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var viewbinding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
    }
}