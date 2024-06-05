package com.ninesevenclub.ludumranking.data.model

import com.google.gson.annotations.SerializedName

data class GameItem(
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("dominant_color")
    val dominantColor: String,
    val genres: List<Genre>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val playtime: Int,
    val released: String,
    @SerializedName("saturated_color")
    val saturatedColor: String,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshot>
)