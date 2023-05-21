package com.dyongchan.ch05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.dyongchan.ch05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var UserList = arrayListOf<User>(
        User(R.drawable.ic_android_black_24dp,"홍드로이드","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"안녕","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"조용찬","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"안드로이드","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"코틀린","안녕하세요","28"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27"),
        User(R.drawable.ic_android_black_24dp,"자바","안녕하세요","27")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val item = arrayOf("과일","고기","야채","해산물")
//
//        binding.listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this,UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener {parent, view, position, id ->
            // 해당 포지션의 열로 부터 정보를 가져오게 하기
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this@MainActivity,selectItem.name,Toast.LENGTH_SHORT).show()


        }
    }
}