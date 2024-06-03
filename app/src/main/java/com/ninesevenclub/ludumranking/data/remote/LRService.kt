package com.ninesevenclub.ludumranking.data.remote

import android.telecom.Call
import com.ninesevenclub.ludumranking.data.model.GameResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface LRService {
    //https://rawg.io/apidocs 192d53844b6b46d782e8cc8728ae44ff
    @GET("games?key={api_key}")
    fun listGames(@Path("api_key") apiKey: String = "192d53844b6b46d782e8cc8728ae44ff"): List<GameResponse>

}