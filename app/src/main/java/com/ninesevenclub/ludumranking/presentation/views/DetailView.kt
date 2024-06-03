package com.ninesevenclub.ludumranking.presentation.views

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
import androidx.core.app.Person

@Composable
fun DetailView(
    paddingValues: PaddingValues
) {
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
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Sitio Web")
                }
            }
            //PuntuationItem
        }
        Text(text = "")
    }
}