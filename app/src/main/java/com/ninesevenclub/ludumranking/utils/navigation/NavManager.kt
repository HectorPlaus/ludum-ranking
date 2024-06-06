package com.ninesevenclub.ludumranking.utils.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel
import com.ninesevenclub.ludumranking.presentation.views.DetailView
import com.ninesevenclub.ludumranking.presentation.views.HomeView
import com.ninesevenclub.ludumranking.presentation.views.SearchView

@Composable
fun NavManager(paddingValues: PaddingValues, viewModel: LRViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.HomeView.route) {
        composable(Routes.HomeView.route) {
            HomeView(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(Routes.DetailView.route) {
            DetailView(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(Routes.SearchView.route) {
            SearchView(
                viewModel = viewModel
            )
        }
    }
}