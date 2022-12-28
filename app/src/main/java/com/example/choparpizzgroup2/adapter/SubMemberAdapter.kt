package com.example.choparpizzgroup2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.choparpizzgroup2.R
import com.example.choparpizzgroup2.databinding.MenuItemLyBinding
import com.example.choparpizzgroup2.databinding.MenuSubItemLyBinding
import com.example.choparpizzgroup2.model.ResultModel

class SubMemberAdapter(val baseList: List<ResultModel.SubMember>) :
    RecyclerView.Adapter<SubMemberAdapter.ItemHolder>() {
    inner class ItemHolder(val b: MenuSubItemLyBinding) : RecyclerView.ViewHolder(b.root) {

        fun bind(result: ResultModel.SubMember) {
            b.titleText.text = result.title
//            Picasso.get().load(result.image).error(R.drawable.ic_launcher_background).into(b.image)
            b.infoText.text = result.description
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