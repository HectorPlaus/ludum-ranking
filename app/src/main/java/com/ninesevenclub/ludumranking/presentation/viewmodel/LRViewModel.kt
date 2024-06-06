package com.ninesevenclub.ludumranking.presentation.viewmodel

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninesevenclub.ludumranking.data.Repository
import com.ninesevenclub.ludumranking.data.model.GameItem
import com.ninesevenclub.ludumranking.data.model.GamesDetailResponse
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

    private val _selectedGame = MutableStateFlow<GamesDetailResponse?>(null)
    val selectedGame = _selectedGame.asStateFlow()

    init {
        getGameList()
    }

    fun updateSelectedGame(game: GameItem) {
        _selectedGameItem.value = game
    }

    fun getGameDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getGameDetails(id = id)
                _selectedGame.value = response
            } catch (e: Exception) {
                Log.e("Error:", e.message.toString())
            }
        }
    }

    private fun getGameList() {
        viewModelScope.launch {
            try {
                val response = repository.getListGames()
                _gameList.value = response.results
            } catch (e: Exception) {
                Log.e("Error:", e.message.toString())
            }
        }
    }

    fun webIntent(url: String): Intent {
        return Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }
}