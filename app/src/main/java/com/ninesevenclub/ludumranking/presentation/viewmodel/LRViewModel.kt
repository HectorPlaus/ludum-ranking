package com.ninesevenclub.ludumranking.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninesevenclub.ludumranking.data.Repository
import com.ninesevenclub.ludumranking.data.model.GameResponse
import com.ninesevenclub.ludumranking.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LRViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _gameList = MutableStateFlow(emptyList<Result>())
    val gameList = _gameList.asStateFlow()

    init {
        getGameList()
    }

    private fun getGameList() {
        viewModelScope.launch {
            try {
                val response = repository.getListGames()
                _gameList.value = response.results
            }catch (e: Exception){
                Log.e("Error:", e.message.toString())
            }


        }
    }
}