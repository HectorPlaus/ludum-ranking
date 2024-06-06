package com.ninesevenclub.ludumranking.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontFamily
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
                    Column(modifier = Modifier.padding(top = 12.dp)) {
                        Text(
                            text = selectedGame!!.name,
                            textAlign = TextAlign.Center,
                            color = Color.LightGray,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif
                        )
                    }

                }
                Image(
                    painter = rememberAsyncImagePainter(selectedGame!!.backgroundImage),
                    contentDescription = "BACKGROUND"
                )

                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(
                            text = "METASCORE",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            fontFamily = FontFamily.Serif
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Button(onClick = {
                            context.startActivity(viewModel.webIntent(selectedGame!!.website))
                        }, colors = ButtonDefaults.buttonColors(Color.Gray)) {
                            Text(text = "Sitio Web",fontFamily = FontFamily.Serif,)
                        }

                    }
                    Box(
                        Modifier

                            .size(80.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color(0xFF3BC42F)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = selectedGame!!.metacritic.toString(),
                            color = Color.White,
                            fontSize = 50.sp
                        )
                    }
                }
                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(5.dp)) {
                    Text(
                        text = selectedGame!!.description,
                        color = Color.LightGray,
                        fontFamily = FontFamily.Serif,
                    )
                }



            }

        }
    }
}