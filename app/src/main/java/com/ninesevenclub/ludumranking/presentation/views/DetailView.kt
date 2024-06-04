package com.ninesevenclub.ludumranking.presentation.views

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.app.Person
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ninesevenclub.ludumranking.R
import com.ninesevenclub.ludumranking.presentation.viewmodel.LRViewModel

@Composable
fun DetailView(viewModel: LRViewModel,navController: NavHostController,paddingValues: PaddingValues) {
    val context = LocalContext.current
    val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("url"))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        //Image
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                Row {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = ""
                    )
                    Text(text = "title.value")
                }
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
                Row {
                    Column {
                        Text(text = "METASCORE")
                        Button(onClick = {
                            context.startActivity(webIntent)
                        }) {
                            Text(text = "Sitio Web")
                        }

                }
                    Box(Modifier){
                        Text(text = "metacritic.value")
                    }

            }
                Text(text = "description.value")

        }

    }
    }
}