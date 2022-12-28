package com.example.choparpizzgroup2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.choparpizzgroup2.databinding.MenuItemLyBinding
import com.example.choparpizzgroup2.model.ResultModel

class MenuAdapter(val baseList: List<ResultModel>): RecyclerView.Adapter<MenuAdapter.ItemHolder>(){

    inner class ItemHolder(val b: MenuItemLyBinding): RecyclerView.ViewHolder(b.root){
        fun bind(result: ResultModel) {

            b.subRecTitle.text = result.title

            val subMemberAdapter = SubMemberAdapter(result.members)
            b.subRecView.layoutManager = LinearLayoutManager(b.root.context, LinearLayoutManager.VERTICAL, false)//VERTICAL
            b.subRecView.adapter = subMemberAdapter

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(MenuItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        holder.bind(itemData)
    }

    override fun getItemCount(): Int = baseList.size

}