package com.example.choparpizzgroup2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.choparpizzgroup2.adapter.MenuAdapter
import com.example.choparpizzgroup2.databinding.ActivityMainBinding
import com.example.choparpizzgroup2.model.ResultModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var menuList = mutableListOf<ResultModel>()
    private val menuSubList = mutableListOf<ResultModel.SubMember>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLists()
        binding.homeRecycler.layoutManager = LinearLayoutManager(this)
        binding.homeRecycler.adapter = MenuAdapter(menuList)
    }

    private fun initLists() {
        for (i in 1..6) {
            menuSubList.add(
                ResultModel.SubMember(
                    R.drawable.ic_launcher_background,
                    "name $i",
                    "description $i"
                )
            )
        }
        for (i in 0..4) {
            menuList.add(ResultModel("Menu title $i", menuSubList))
        }

    }
}