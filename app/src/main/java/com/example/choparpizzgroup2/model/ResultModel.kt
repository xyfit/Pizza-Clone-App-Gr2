package com.example.choparpizzgroup2.model

data class ResultModel(
    val title: String,
    val members: List<SubMember>
){
    data class SubMember(
        val image: Int,
        val title: String,
        val description: String,
        val price: String = "12 345.45"
    )
}