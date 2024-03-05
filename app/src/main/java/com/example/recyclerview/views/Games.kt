package com.example.recyclerview.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recyclerview.R

@Preview(showBackground = true)
@Composable
fun CardFame() {

    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.mario),
                contentDescription = "Mario y Sonic"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column( modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Mario y Sonic en los juegos olímpicos",
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(
                        0xFF0C71A0
                    )
                )
                GameDataView(modifier = Modifier.fillMaxWidth())
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Comprar")
                }
            }
        }
    }
}