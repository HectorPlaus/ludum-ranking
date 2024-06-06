package com.ninesevenclub.ludumranking.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninesevenclub.ludumranking.data.Repository
import com.ninesevenclub.ludumranking.data.model.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LRViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    //SearchBar
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _gameList = MutableStateFlow<List<GameItem>>(emptyList())
    @OptIn(ExperimentalCoroutinesApi::class)
    val gameList = _searchText.flatMapLatest { text ->
        flow {
            val filteredList = if (text.isBlank()) {
                getAllGames()
            } else {
                getAllGames().filter { game ->
                    game.name.contains(text, ignoreCase = true)
                }
            }
            emit(filteredList)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _selectedGameItem = MutableStateFlow<GameItem?>(null)
    val selectedGameItem = _selectedGameItem.asStateFlow()

    init {
        viewModelScope.launch {
            getAllGames() // Fetch initial list on ViewModel initialization
        }
    }

    fun updateSelectedGame(game: GameItem) {
        _selectedGameItem.value = game
    }

    private suspend fun getAllGames(): List<GameItem> {
        return try {
            repository.getListGames().results
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            emptyList() // Return an empty list on error
        }
    }

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onToogleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }
}