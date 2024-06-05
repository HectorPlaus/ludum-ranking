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
    @GET("games?key={api_key}")
    suspend fun listGames(@Query("api_key") apiKey: String = "192d53844b6b46d782e8cc8728ae44ff"): GameResponse

    companion object {
        private const val BASE_URL = "https://api.rawg.io/api/"
        fun create(): LRService {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client).build()
            return retrofit.create(LRService::class.java)
        }
    }
}