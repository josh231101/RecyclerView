package com.example.recyclerview.screens

import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.recyclerview.viewmodels.GamesViewModel
import com.example.recyclerview.views.CardGame

@Composable
fun FormView(navController: NavHostController) {
    var budget by remember {
        mutableStateOf(0)
    }
    var age by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextField(value = budget.toString(), onValueChange = {
            budget = checkWroteNumber(it)
        }, label= {
            Text(text = "Presupuesto:")
        }, placeholder =  {
            Text(text = "Porfavor escribe un número")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Icon")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        TextField(value = age.toString(), onValueChange = {
            age = checkWroteNumber(it)
        }, label= {
            Text(text = "Edad:")
        }, placeholder =  {
            Text(text = "Porfavor escribe un número")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Icon")
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Button(enabled = budget != 0 && age != 0, onClick = {
            navController.navigate("Cart/${budget}/${age}")
        }) {
            Text(text = "Ir a la cesta")
        }
    }
}

@Composable
fun CartView(navController: NavHostController, budget: Int, age: Int) {
    val games = GamesViewModel()
    var currentBudget by remember {
        mutableStateOf(budget)
    }
    var currentCart by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current
    var creditExceed = false
    fun restar(precioJuego: Int) {
        if( currentBudget - precioJuego < 0) {
            creditExceed = true
            Toast.makeText(context, "No tienes suficiente crédito", Toast.LENGTH_SHORT).show()
            return
        }
        currentBudget -= precioJuego
        currentCart += precioJuego
    }
    //Llamar y mostrar la lista
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.padding(20.dp)) {
            Text(text = "Presupuesto disponible: ${currentBudget}", fontSize = 20.sp)
        }
        Button(onClick = {
            Toast.makeText(context, "Gastaste un total de: ${currentCart}", Toast.LENGTH_SHORT).show()

        }) {
            Text(text = "Finalizar compra")
        }
        LazyColumn {
            items(games.getGameList()) {
                    game ->
                //Dentro de los parentesis va la lista o arreglo de la lista
                //Dentro de las llaves seria la vista a repetir
                CardGame(game, age, ::restar)
            }
        }

    }
}

fun checkWroteNumber(text: String): Int {
    if(text.toIntOrNull() != null) {
        return text.toInt()
    } else if (TextUtils.isEmpty(text)) {
        return 0
    }
    return 0
}

@Preview(showBackground = true)
@Composable
fun test(){
    CartView(navController = rememberNavController(), 1000, 20)
}