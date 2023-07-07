package com.dev.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dev.activity.databinding.ActivitySecondBinding
import com.dev.activity.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewbinding : ActivityThirdBinding
   var result:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(viewbinding.fragmentContainer.id,firstFragment)
            .commitNowAllowingStateLoss()
        viewbinding.btFirstFragment.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewbinding.fragmentContainer.id,firstFragment)
                .commitNowAllowingStateLoss()
        }
        viewbinding.btSecondFragment.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewbinding.fragmentContainer.id,secondFragment)
                .commitNowAllowingStateLoss()
        }
        supportFragmentManager
            .setFragmentResultListener("requestKey", this) { requestKey, bundle ->
                result = bundle.getString("bundleKey").toString()
                Toast.makeText(this@ThirdActivity,result,Toast.LENGTH_LONG).show()
            }
    }
}