package com.example.choparpizzgroup2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.choparpizzgroup2.R
import com.example.choparpizzgroup2.databinding.MenuSubItemLyBinding
import com.example.choparpizzgroup2.model.ResultModel
import com.squareup.picasso.Picasso

class SubMemberAdapter(val baseList: List<ResultModel.SubMember>, val onItemCallback: OnItemCallback) :
    RecyclerView.Adapter<SubMemberAdapter.ItemHolder>() {


    inner class ItemHolder(val b: MenuSubItemLyBinding) : RecyclerView.ViewHolder(b.root) {

        fun bind(itemData: ResultModel.SubMember) {
            Picasso.get().load("https://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_baseline_23mp_24)
                .into(b.image)
//            Picasso.get().load("https://i.imgur.com/DvpvklR.png").error(R.drawable.ic_baseline_23mp_24).into(b.image);
            b.titleText.text = itemData.title
//            Picasso.get().load(result.image).error(R.drawable.ic_launcher_background).into(b.image)
            b.infoText.text = itemData.description

            itemView.setOnClickListener {
                onItemCallback.subMemberItemClick(itemData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        return ItemHolder(MenuSubItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        holder.bind(itemData)
    }

    override fun getItemCount(): Int = baseList.size
}

interface OnItemCallback{
    fun subMemberItemClick(s: ResultModel.SubMember)
}
