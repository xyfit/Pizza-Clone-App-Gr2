package com.example.choparpizzgroup2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class ResultModel(
    val title: String,
    val members: List<SubMember>
){

    @Parcelize
    data class SubMember(
        val image: Int,
        val title: String,
        val description: String,
        val price: String = "12 345.45"
    ): Parcelable
}
