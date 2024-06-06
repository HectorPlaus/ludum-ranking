package com.ninesevenclub.ludumranking.data

import com.ninesevenclub.ludumranking.data.model.GameResponse
import com.ninesevenclub.ludumranking.data.remote.LRService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: LRService) {
    suspend fun getListGames() = apiInterface.listGames()
    suspend fun getGameDetails(id: Int) = apiInterface.getGameDetails(id = id)


}