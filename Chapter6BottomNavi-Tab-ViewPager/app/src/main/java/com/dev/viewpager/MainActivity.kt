package com.dev.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayout.id, HomeFragment())
            .commit()
        binding.bottomNavi.run {
            setOnItemSelectedListener{item->
                when(item.itemId){
                    R.id.circleFragment -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.frameLayout.id, CircleFragment())
                            .commit()
                    }
                    R.id.homeFragment -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.frameLayout.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.plantFragment -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.frameLayout.id, PlantFragment())
                            .commitAllowingStateLoss()
                    }

                }
                true

            }
            selectedItemId = R.id.homeFragment

        }
    }


}