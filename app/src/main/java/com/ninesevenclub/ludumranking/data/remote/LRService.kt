package com.ninesevenclub.ludumranking.data.remote

import com.ninesevenclub.ludumranking.data.model.GameResponse
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface LRService {
    //https://rawg.io/apidocs 192d53844b6b46d782e8cc8728ae44ff
    @GET("games")
    suspend fun listGames(@Query("key") apiKey: String = "192d53844b6b46d782e8cc8728ae44ff"): GameResponse

}