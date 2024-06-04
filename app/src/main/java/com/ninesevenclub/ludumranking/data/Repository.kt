package com.ninesevenclub.ludumranking.data

import com.ninesevenclub.ludumranking.data.remote.LRService
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: LRService) {
    fun getListGames() = apiInterface.listGames()
}