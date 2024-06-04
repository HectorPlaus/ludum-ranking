package com.ninesevenclub.ludumranking.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.app.Person
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel

@Composable
fun HomeView(
    viewModel: LRViewModel,
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    val gameList by viewModel.gameList.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        LazyColumn() {
            items(gameList) { game ->
                //GameCardItem
                Text(text = game.name)
            }
        }
    }
}