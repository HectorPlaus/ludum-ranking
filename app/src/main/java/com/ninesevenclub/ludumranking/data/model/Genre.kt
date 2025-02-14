package com.ninesevenclub.ludumranking.data.model

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("games_count")
    val gamesCount: Int,
    val id: Int,
    @SerializedName("image_background")
    val imageBackground: String,
    val name: String,
    val slug: String
)