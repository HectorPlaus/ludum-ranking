package com.ninesevenclub.ludumranking.presentation.views

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.Person
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel
import com.ninesevenclub.ludumranking.presentation.views.components.LRTopBar
import com.ninesevenclub.ludumranking.utils.navigation.Routes

@Composable
fun HomeView(
    viewModel: LRViewModel,
    navController: NavHostController
) {
    val gameList by viewModel.gameList.collectAsState()
    Scaffold(
        topBar = {
            LRTopBar(
                navToSettings = { /*TODO*/ },
                navToSearch = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color.Black)
        ) {
            LazyColumn() {
                items(gameList) { game ->
                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(color = Color.Black)
                            .clickable {
                                //viewModel.updateSelectedGame(game)
                                viewModel.getGameDetails(game.id)
                                navController.navigate(Routes.DetailView.route)
                            }) {
                        Image(
                            painter = rememberAsyncImagePainter(game.backgroundImage),
                            contentDescription = "Game Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = game.name,
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(color = Color.Black)
                                .fillMaxWidth()
                                .padding(5.dp)
                        )

                    }


                }
            }
        }

    }
}