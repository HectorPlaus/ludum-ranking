package com.ninesevenclub.ludumranking.presentation.views.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LRTopBar(
    navToSettings: () -> Unit,
    navToSearch: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "API GAMES") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { navToSettings() }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "SETTINGS")
            }
        },
        actions = {
            IconButton(onClick = { navToSearch() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "SEARCH")
            }
        }
    )
}