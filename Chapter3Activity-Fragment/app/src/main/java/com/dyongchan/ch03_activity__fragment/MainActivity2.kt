package com.dyongchan.ch03_activity__fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dyongchan.ch03_activity__fragment.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflater : xml을 파싱하여 객체화
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainToast.setOnClickListener() {
            val input = binding.etMain.text.toString()
            Toast.makeText(this@MainActivity2, input, Toast.LENGTH_LONG).show()
        }

        binding.btnMainIntent.setOnClickListener() {
            val Intent = Intent(this,MainActivity3::class.java)
            val data = binding.etMain.text.toString()
            Intent.putExtra("etinput", data)
            startActivity(Intent)
        }

        binding.btnGoFragment.setOnClickListener {
            val Intent = Intent(this,fragment_main::class.java)
            startActivity(Intent)
        }


    }
}