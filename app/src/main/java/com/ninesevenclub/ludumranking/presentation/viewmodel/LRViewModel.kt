package com.ninesevenclub.ludumranking.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninesevenclub.ludumranking.data.Repository
import com.ninesevenclub.ludumranking.data.model.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LRViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _gameList = MutableStateFlow(emptyList<GameItem>())
    val gameList = _gameList.asStateFlow()

    private val _selectedGameItem = MutableStateFlow<GameItem?>(null)
    val selectedGameItem = _selectedGameItem.asStateFlow()
    init {
        getGameList()
    }

    fun updateSelectedGame(game: GameItem) {
        _selectedGameItem.value = game
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