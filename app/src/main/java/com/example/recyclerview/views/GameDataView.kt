package com.example.recyclerview.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable()
fun GameDataView(modifier: Modifier = Modifier.fillMaxWidth()) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
        Text(text = "Wii")
        Text(text = "$400")
    }
}