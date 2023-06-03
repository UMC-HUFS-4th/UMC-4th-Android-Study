package com.dev.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dev.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bn_nav = binding.bnNav

        //초기 fragment 지정
        changeFragment(HomeFragment())


        bn_nav.setOnItemSelectedListener { item ->
            changeFragment(
                when(item.itemId) {
                    R.id.menu_home -> HomeFragment()
                    R.id.menu_search -> SearchFragment()
                    R.id.menu_setting -> SettingFragment()
                    else -> HomeFragment()
                }
            )
            true
        }
        bn_nav.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment : Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_nav, fragment)
            .commit()

    }
}