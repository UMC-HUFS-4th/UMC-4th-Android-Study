package com.example.lifecycleprac.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycleprac.ItemClickListener
import com.example.lifecycleprac.R

class MemoAdapter(private val dataList: MutableList<String>, private val itemClickListener: ItemClickListener): RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.textView.text = dataList[position]
        holder.handleMemoClicked(position, itemClickListener)
    }

    override fun getItemCount(): Int = dataList.size

    inner class MemoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.tv_memo_content)

        fun handleMemoClicked(position: Int, itemClickListener: ItemClickListener) {
            view.setOnClickListener {
//                itemClickListener.onClickItemDelete(position)
                itemClickListener.onClickItemEdit(dataList[position], position)
            }
        }
    }
}