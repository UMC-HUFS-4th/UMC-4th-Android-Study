package com.dyongchan.ch05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.dyongchan.ch05.databinding.ActivitySimpleListviewBinding

class SimpleListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = arrayOf("1","2","3","4","5")

        binding.simpleListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
    }

}