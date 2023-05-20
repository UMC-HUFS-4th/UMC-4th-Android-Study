package com.dev.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.recyclerview.databinding.ActivityMainBinding
import com.dev.recyclerview.databinding.MemoListBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
    var datalist = mutableListOf<MemoData>()

    //viewholder
    inner class MyViewHolder(private val binding: MemoListBinding):RecyclerView.ViewHolder(binding.root){
        //binding을 전달받아서 viewholder 내에서 binding 사용가능
        fun bind(memoData : MemoData){
            binding.tvMemo.text = memoData.memo
            binding.tvDate.text = memoData.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MemoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}