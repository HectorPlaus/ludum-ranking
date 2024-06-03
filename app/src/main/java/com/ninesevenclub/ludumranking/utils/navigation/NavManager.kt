package com.ninesevenclub.ludumranking.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "") {

    }
}