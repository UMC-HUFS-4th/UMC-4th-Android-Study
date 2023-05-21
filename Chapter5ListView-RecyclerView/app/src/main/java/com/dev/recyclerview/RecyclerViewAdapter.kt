package com.dev.recyclerview

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.recyclerview.databinding.ActivityMainBinding
import com.dev.recyclerview.databinding.MemoListBinding

class RecyclerViewAdapter(private val clickListener: OnMemoClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
    var datalist = mutableListOf<MemoData>()
    private lateinit var binding : MemoListBinding

    //viewholder, view에 내용 입력
    inner class MyViewHolder(private val binding: MemoListBinding):RecyclerView.ViewHolder(binding.root){
        //binding을 전달받아서 viewholder 내에서 binding 사용가능
        fun bind(memoData : MemoData){
            binding.tvMemo.text = memoData.memo
            binding.tvDate.text = memoData.date
        }
    }

    //아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = MemoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    //리스트 내 아이템 개수
    override fun getItemCount(): Int = datalist.size

    //레이아웃 내 view 연결
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
        //길게 눌렀을 때 삭제
        binding.root.setOnLongClickListener {
            datalist.removeAt(position)
            notifyDataSetChanged()
            Log.d(TAG, "잘 지워짐")

            true
        }
        //눌렀을 때 수정
        binding.root.setOnClickListener {
            clickListener.onMemoClick(position)
            datalist.removeAt(position)
            notifyDataSetChanged()
        }

    }

    interface OnMemoClickListener {
        fun onMemoClick(position: Int)
    }
}