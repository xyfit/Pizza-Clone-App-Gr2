package com.example.choparpizzgroup2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.choparpizzgroup2.databinding.MenuItemLyBinding
import com.example.choparpizzgroup2.model.ResultModel





class MenuAdapter(val baseList: List<ResultModel>, val onItemCallback: OnItemCallback): RecyclerView.Adapter<MenuAdapter.ItemHolder>(){
var step = 0
    inner class ItemHolder(val b: MenuItemLyBinding): RecyclerView.ViewHolder(b.root){
        fun bind(result: ResultModel) {

            b.subRecTitle.text = result.title

            val onItemCallback = object: OnItemCallback{
                override fun subMemberItemClick(s: ResultModel.SubMember) {
                    onItemCallback.subMemberItemClick(s)
                }
            }
            val subMemberAdapter = SubMemberAdapter(result.members, onItemCallback)

            b.subRecView.layoutManager = LinearLayoutManager(b.root.context, LinearLayoutManager.VERTICAL, false)//VERTICAL
            b.subRecView.adapter = subMemberAdapter

            itemView.setOnClickListener {
                onItemClickListener?.let {
                    it("${step++}")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(MenuItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        holder.bind(itemData)
    }


    private var onItemClickListener: ((String) -> Unit)? = null
    fun setOnItemClickListener(listener: ((String) -> Unit)? = null) {
        onItemClickListener = listener

    }
    override fun getItemCount(): Int = baseList.size

}