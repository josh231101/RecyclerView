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
import com.example.recyclerview.models.Game

@Composable
fun CardGame(game: Game, age: Int, onBuy: (gameCost: Int) -> Unit) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = game.image),
                contentDescription = "Juego"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column( modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = game.name,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(
                        0xFF0C71A0
                    )
                )
                GameData(game.name, game.price)
                Text(text = "Clasificación: ${game.ageRate}")
                Button(onClick = { onBuy(game.price) }, enabled = checkUserValidity(age, game.ageRate)) {
                    Text(text = "Comprar")
                }
            }
        }
    }
}

fun checkUserValidity(edad: Int, tipoJuego: String): Boolean {
    return when {
        edad < 18 && tipoJuego == "R" -> false // Menores de 18 no pueden comprar juegos R
        edad <= 5 && (tipoJuego == "T" || tipoJuego == "R") -> false // Niños de 5 años no pueden comprar juegos T ni R
        else -> true // En cualquier otro caso, la compra es válida
    }
}