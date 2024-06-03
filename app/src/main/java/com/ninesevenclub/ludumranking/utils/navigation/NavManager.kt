package com.ninesevenclub.ludumranking.utils.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel

@Composable
fun NavManager(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: LRViewModel
) {
    NavHost(navController, startDestination = "") {

    }
}