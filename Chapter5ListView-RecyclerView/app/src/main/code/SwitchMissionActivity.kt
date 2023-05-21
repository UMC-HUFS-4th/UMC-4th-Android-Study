package com.example.lifecycleprac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecycleprac.adapter.MyAdapter
import com.example.lifecycleprac.databinding.ActivitySubBinding


class SwitchMissionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dataList = mutableListOf<String>()
        for(i in 0..20) {
            dataList.add(i.toString())
        }

        binding.rvSwitchContainer.adapter = MyAdapter(dataList.toList())
    }
}