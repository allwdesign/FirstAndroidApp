package ru.allwdesign.firstapplication.domain.model

import androidx.annotation.DrawableRes

data class AppData(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val icon: Int,
    val category: String
)