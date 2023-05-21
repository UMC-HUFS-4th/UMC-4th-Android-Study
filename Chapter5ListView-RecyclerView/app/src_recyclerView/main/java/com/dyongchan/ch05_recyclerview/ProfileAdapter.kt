package com.dyongchan.ch05_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        // 생성한 리스트의 구성을 붙이는 작업
        // parent.context : 연결할 Activity의 모든 정보를 가져옴
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        // 생성한 view를 CustomViewHolder로 전달
        return CustomViewHolder(view).apply {
            // Click 처리
            itemView.setOnClickListener {
                // curPos : 현재 클릭 위치 변수명
                val curPos : Int = adapterPosition
                // 원하는 데이터를 가져오기 위한 객체생성
                val profile: Profiles = profileList.get(curPos)
                //parent.context : adapter와 연결 되어 있는 액티비티
                Toast.makeText(parent.context, "이름 : ${profile.name} 나이 : ${profile.age} 직업 : ${profile.job}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        // view의 실제적인 연결 : 데이터의 매칭 (Scroll, 작업 등)
        // position : 현재 item의 위치 (클릭, 작업)
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString() // int 형태이기 때문에
        holder.job.text = profileList.get(position).job
    }

    override fun getItemCount(): Int {
        // List의 총 개수 적기
        return profileList.size
    }

    // 내부클래스로 ViewHolder 생성
    class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.ivProfile) // 성별
        val name = itemView.findViewById<TextView>(R.id.tvName) // 이름
        val age = itemView.findViewById<TextView>(R.id.tvage) // 나이
        val job = itemView.findViewById<TextView>(R.id.tvJob) // 직업

    }
}