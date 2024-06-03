package com.ninesevenclub.ludumranking.data.model

data class Result(
    val background_image: String,
    val dominant_color: String,
    val genres: List<Genre>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val playtime: Int,
    val released: String,
    val saturated_color: String,
    val short_screenshots: List<ShortScreenshot>
)