package com.ninesevenclub.ludumranking.presentation.views
import android.annotation.SuppressLint
import android.widget.SearchView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel
import com.ninesevenclub.ludumranking.utils.navigation.NavManager
import com.ninesevenclub.ludumranking.utils.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(viewModel: LRViewModel, navController: NavHostController) {
    val searchText by viewModel.searchText.collectAsState()
    val gameSearchList by viewModel.gameList.collectAsState()

    Scaffold(
        contentColor = Color.White,
        containerColor = Color.Black
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Search Bar using TextField
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = "BACK",
                        tint = Color.LightGray,
                        modifier = Modifier.size(30.dp)
                    )
                }

                TextField(
                    value = searchText,
                    onValueChange = { viewModel.onSearchTextChange(it) },
                    label = {
                        if (searchText.isEmpty()) {
                            Text("Search")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, end = 64.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    trailingIcon = {
                        if (searchText.isNotEmpty()) {
                            IconButton(onClick = { viewModel.onSearchTextChange("") }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Clear Search"
                                )
                            }
                        }
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(focusedLabelColor = Color.Transparent),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start)

                )
            }


            // Display Search Results
            LazyColumn {
                items(gameSearchList) { game ->
                    Text(
                        text = game.name,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable
                            {
                                viewModel.getGameDetails(game.id)
                                navController.navigate(Routes.DetailView.createRoute(game.id))
                            }
                    )
                }
            }
        }
    }
}