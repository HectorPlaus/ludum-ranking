package com.ninesevenclub.ludumranking.data.model

import com.google.gson.annotations.SerializedName

class GamesDetailResponse(
    val id: Int,
    val name: String,
    val description: String,
    val metacritic: Int,
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("background_image_additional")
    val backgroundImageAdditional: String,
    val website: String,
    @SerializedName("reddit_url")
    val redditUrl: String,
    @SerializedName("reddit_logo")
    val redditLogo: String
)