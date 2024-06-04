package com.ninesevenclub.ludumranking.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninesevenclub.ludumranking.data.Repository
import com.ninesevenclub.ludumranking.data.model.GameResponse
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
    private val _gameList = MutableStateFlow(emptyList<GameResponse>())
    val gameList = _gameList.asStateFlow()

    fun getGameList() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getListGames()
            withContext(Dispatchers.Main) {
                if (!response.isNullOrEmpty()) _gameList.value = response
                else Log.e("Error:", "")
            }
        }
    }
}