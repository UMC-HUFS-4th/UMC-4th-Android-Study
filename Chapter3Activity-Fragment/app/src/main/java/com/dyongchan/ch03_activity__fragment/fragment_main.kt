package com.dyongchan.ch03_activity__fragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dyongchan.ch03_activity__fragment.databinding.ActivityFragmentMainBinding
import com.dyongchan.ch03_activity__fragment.fragments.fragment_lying
import com.dyongchan.ch03_activity__fragment.fragments.fragment_walking

class fragment_main : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentMainBinding

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityFragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trans = supportFragmentManager.beginTransaction()
            .add(R.id.frame, fragment_walking())
        trans.commit()


        binding.btnWalking.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
                .add(R.id.frame,fragment_walking())
            transaction.commit()
        }

        binding.btnLying.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
                .add(R.id.frame,fragment_lying())
            transaction.commit()
        }

        binding.btnRemove.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            val frame = supportFragmentManager.findFragmentById(R.id.frame)
            transaction.remove(frame!!)
            transaction.commit()
        }
    }
}