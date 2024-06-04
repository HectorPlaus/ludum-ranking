package com.ninesevenclub.ludumranking.presentation.views

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.Person
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
                Text(text = "METASCORE")
                Button(onClick = {
                    context.startActivity(webIntent)
                }) {
                    Text(text = "Sitio Web")
                }
            }
            //PuntuationItem
        }
        Text(text = "")
    }
}