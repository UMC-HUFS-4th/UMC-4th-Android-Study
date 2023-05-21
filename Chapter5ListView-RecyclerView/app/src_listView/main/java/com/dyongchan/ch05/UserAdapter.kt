package com.dyongchan.ch05

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// context : Context의 형태를 가지는 변수
class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        // ListView의 행의 개수를 가져옴
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        // ArrayList의 각 위치에 대한 값을 가져옴
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // View를 가지고 왔을 때 어떻게 표현할지 선택해야함
        // LayoutInflater : View를 붙일 때 사용
        // 리스트뷰의 하나의 column 단위를 생성한 list_item_user로 생성
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)

        val profile = view.findViewById<ImageView>(R.id.ivProfile)
        val name = view.findViewById<TextView>(R.id.tvName)
        val age = view.findViewById<TextView>(R.id.tvAge)
        val greet = view.findViewById<TextView>(R.id.tvIntro)

        // position : 표현되는 ListView 행의 위치를 위에서 부터 0,1,2,...으로 지정
        val user = UserList[position]

        // 이미지의 경로를 넣어줄 수 있게 만듬
        profile.setImageResource(user.profile)
        name.text = user.name
        greet.text = user.greet
        age.text = user.age

        return view
    }
}