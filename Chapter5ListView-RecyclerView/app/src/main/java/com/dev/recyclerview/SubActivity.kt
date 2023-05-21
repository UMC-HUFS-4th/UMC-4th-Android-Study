package com.dev.recyclerview

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dev.recyclerview.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("content")
        binding.edtContent.setText(message)

        //onclickListner로 데이터 넘겨주기
        binding.btnSave.setOnClickListener {
            //데이터 넣어서 보내기
            //activity 보내면서 finish()
            val mIntent = Intent(this@SubActivity, MainActivity::class.java).apply {
                putExtra("back_message", binding.edtContent.text.toString())
            }
            Log.d(TAG, "서브에서 보내기 : " + binding.edtContent.text.toString())
            setResult(RESULT_OK, mIntent)
            finish()
        }


    }
}