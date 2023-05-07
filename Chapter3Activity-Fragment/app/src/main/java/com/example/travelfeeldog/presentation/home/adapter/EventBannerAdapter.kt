package com.example.travelfeeldog.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.travelfeeldog.R
import com.example.travelfeeldog.presentation.home.item.EventBanner

class EventBannerAdapter(private val context: Context, private val infoList: MutableList<EventBanner>) :
    RecyclerView.Adapter<EventBannerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_ad_image)
        val subTitle: TextView = itemView.findViewById(R.id.tv_ad_sub_title)
        val mainTitle: TextView = itemView.findViewById(R.id.tv_ad_main_title)
        val view: View = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.pager_home_adv_board, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.image.setImageDrawable(ContextCompat.getDrawable(context, infoList[position].image))
        holder.subTitle.setText(infoList[position].subTitle)
        holder.mainTitle.setText(infoList[position].mainTitle)
        holder.view.setBackgroundResource(infoList[position].background)
    }

    override fun getItemCount() = infoList.size
}