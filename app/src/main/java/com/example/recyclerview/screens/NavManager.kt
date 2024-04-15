package com.example.recyclerview.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavManager() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "Formulario") {
        composable(route = "Formulario") {
            FormView(navController)
        }
        composable(route = "Cart/{budget}/{age}", arguments = listOf(
            navArgument("budget") { type = NavType.IntType },
            navArgument("age") { type = NavType.IntType }
        )) {
            parameers ->
            val budget = parameers.arguments?.getInt("budget") ?: 0
            val age = parameers.arguments?.getInt("age") ?: 0
            CartView(navController, budget, age)
        }
    }

}