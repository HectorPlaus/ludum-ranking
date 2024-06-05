package com.ninesevenclub.ludumranking.utils.navigation

sealed class Routes (val route: String) {
    object HomeView: Routes("gameview")
    object SearchView: Routes("searchview")
    object DetailView: Routes("detailview/{id}"){
        fun createRoute(id: Int) = "detailview/$id"
    }
}