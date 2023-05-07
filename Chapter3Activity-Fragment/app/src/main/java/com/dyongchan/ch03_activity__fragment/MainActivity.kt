package com.dyongchan.ch03_activity__fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main_btn = findViewById<Button>(R.id.btn_main_toast)
        val main_toast = findViewById<EditText>(R.id.et_main)

        main_btn.setOnClickListener(View.OnClickListener {
            val input = main_toast.text.toString();
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
        })

    }

}