package com.dev.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.activity.databinding.ActivitySecondBinding
import com.dev.activity.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewbinding : ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(viewbinding.fragmentContainer.id,firstFragment)
            .commitNowAllowingStateLoss()
        viewbinding.btFirstFragment.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewbinding.fragmentContainer.id,firstFragment)
                .commitNowAllowingStateLoss()
        }
        viewbinding.btSecondFragment.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewbinding.fragmentContainer.id,secondFragment)
                .commitNowAllowingStateLoss()
        }
    }
}