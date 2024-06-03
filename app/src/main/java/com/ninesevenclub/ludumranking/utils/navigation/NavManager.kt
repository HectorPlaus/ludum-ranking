package com.ninesevenclub.ludumranking.utils.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavManager(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(navController, startDestination = "") {

    }
}