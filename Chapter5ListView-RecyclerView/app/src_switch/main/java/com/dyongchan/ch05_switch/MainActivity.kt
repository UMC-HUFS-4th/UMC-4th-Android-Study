package com.dyongchan.ch05_switch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dyongchan.ch05_switch.databinding.ActivityMainBinding

data class BusinessCard(val name: String, val contents : String, var isSwitched: Boolean = false)



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var businessCardArray = ArrayList<BusinessCard>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (x in 0..10) {
            businessCardArray.add(BusinessCard("난","안녕"))
            businessCardArray.add(BusinessCard("난","안녕"))
        }
        customAdapter = CustomAdapter(this@MainActivity, businessCardArray)
        binding.listView.adapter = customAdapter

    }
}