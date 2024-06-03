package com.ninesevenclub.ludumranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ninesevenclub.ludumranking.presentation.ui.theme.LudumRanKingTheme
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel
import com.ninesevenclub.ludumranking.presentation.views.components.LRTopBar
import com.ninesevenclub.ludumranking.utils.navigation.NavManager

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<LRViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LudumRanKingTheme(darkTheme = false) {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        LRTopBar(
                            navToSettings = {},
                            navToSearch = {}
                        )
                    }
                ) { paddingValues ->
                    NavManager(
                        navController = navController,
                        paddingValues = paddingValues,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}



