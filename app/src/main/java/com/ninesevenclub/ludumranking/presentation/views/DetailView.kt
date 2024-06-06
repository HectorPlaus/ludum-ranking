package com.ninesevenclub.ludumranking.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel

@Composable
fun DetailView(
    viewModel: LRViewModel,
    navController: NavHostController
) {
    val selectedGame by viewModel.selectedGame.collectAsState()

    val context = LocalContext.current
    if (selectedGame == null) Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
    else Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                Row {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            contentDescription = "BACK",
                            tint = Color.LightGray
                        )
                    }
                    Text(
                        text = selectedGame!!.name,
                        textAlign = TextAlign.Center,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(
                    painter = rememberAsyncImagePainter(selectedGame!!.backgroundImage),
                    contentDescription = "BACKGROUND"
                )

                Row(modifier = Modifier.padding(15.dp)) {
                    Column {
                        Text(
                            text = "METASCORE",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )
                        Button(onClick = {
                            context.startActivity(viewModel.webIntent(selectedGame!!.website))
                        }) {
                            Text(text = "Sitio Web")
                        }

                    }
                    Spacer(modifier = Modifier.size(70.dp))
                    Box(
                        Modifier
                            .background(color = Color.Green)
                            .size(70.dp)
                            .clip(shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = selectedGame!!.metacritic.toString(),
                            color = Color.White,
                            fontSize = 50.sp
                        )
                    }
                }
                Text(
                    text = selectedGame!!.description,
                    color = Color.LightGray
                )


            }

        }
    }
}