package com.ninesevenclub.ludumranking.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("background_image")
    val background_image: String,
    @SerializedName("dominant_color")
    val dominant_color: String,
    val genres: List<Genre>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val playtime: Int,
    val released: String,
    @SerializedName("saturated_color")
    val saturated_color: String,
    @SerializedName("short_screenshots")
    val short_screenshots: List<ShortScreenshot>
)