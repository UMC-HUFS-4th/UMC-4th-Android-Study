package com.dyongchan.ch05_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dyongchan.ch05_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileList = arrayListOf(

            Profiles(R.drawable.man,"조영찬",82,"농부"),
            Profiles(R.drawable.man,"조양찬",33,"카카오 개발자"),
            Profiles(R.drawable.man,"조종찬",102,"연장자"),
            Profiles(R.drawable.woman,"조종찬",102,"연장자"),
            Profiles(R.drawable.man,"조종찬",102,"연장자")
        )

        // vertical = 세로 방향의 listView로 만들기
        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // recyclerView : 성능 개선
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = ProfileAdapter(profileList)
    }
}