package com.ninesevenclub.ludumranking.utils.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel
import com.ninesevenclub.ludumranking.presentation.views.DetailView
import com.ninesevenclub.ludumranking.presentation.views.HomeView
import com.ninesevenclub.ludumranking.presentation.views.SearchView

@Composable
fun NavManager(navController: NavHostController, paddingValues: PaddingValues, viewModel: LRViewModel
) {
    NavHost(navController, startDestination = Routes.HomeView.route) {
        composable(Routes.HomeView.route){ HomeView(viewModel = viewModel, navController = navController, paddingValues = paddingValues) }
        composable(Routes.DetailView.route){ DetailView(viewModel = viewModel, navController = navController, paddingValues = paddingValues)}
        composable(Routes.SearchView.route){ SearchView(viewModel = viewModel, navController = navController, paddingValues = paddingValues)}
    }
}