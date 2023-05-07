package com.dev.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dev.activity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewbinding :ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        val bundle = intent.extras
        var tmpString = ""
        if(bundle!=null){
            tmpString = bundle.getString("text","have no text")
            Log.d("Second activity", tmpString)
        }
        viewbinding.tvSecondActivity.text = tmpString
    }
}