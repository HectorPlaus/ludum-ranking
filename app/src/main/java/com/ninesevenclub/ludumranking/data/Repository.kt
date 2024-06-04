package com.ninesevenclub.ludumranking.data

import com.ninesevenclub.ludumranking.data.remote.LRService
import javax.inject.Inject

class Repository {
    val apiInterface = LRService.create()
    fun getListGames() = apiInterface.listGames()
}