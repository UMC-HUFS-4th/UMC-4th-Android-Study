package com.example.ch3_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch3_app.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val message = intent.getStringExtra("tv_main")
        binding.tvSub.setText(message)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnPrev.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("back_message", "Back")
            }
            setResult(RESULT_OK, mIntent)
            finish()
        }

    }
}