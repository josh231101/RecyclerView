package com.example.recyclerview.models

import androidx.annotation.DrawableRes

data class Game(
    val name: String,
    val price: Int,
    val console: String,
    @DrawableRes val image: Int
)
