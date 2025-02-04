package com.ninesevenclub.ludumranking.data.remote

import com.ninesevenclub.ludumranking.data.model.GameResponse
import com.ninesevenclub.ludumranking.data.model.GamesDetailResponse
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface LRService {
   
    @GET("games")
    suspend fun listGames(@Query("key") apiKey: String = API_KEY): GameResponse

    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: Int,
        @Query("key") apiKey: String = API_KEY
    ): GamesDetailResponse
}
