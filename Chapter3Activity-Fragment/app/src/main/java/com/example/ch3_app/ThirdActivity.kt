package com.example.ch3_app

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ch3_app.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private var firstFragment = FirstFragment()
    private var secondFragment = SecondFragment()
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_zone, firstFragment)
            .addToBackStack(null)
            .commit()

        supportFragmentManager
            .setFragmentResultListener("requestKey", this) { requestKey, bundle ->
                val result = bundle.getString("bundleKey")
                Log.d(TAG, "받은 값은 ${result} 입니다.")
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }

        binding.btnFirst.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_zone, firstFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.btnSecond.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_zone, secondFragment)
                .addToBackStack(null)
                .commit()
        }



    }
}