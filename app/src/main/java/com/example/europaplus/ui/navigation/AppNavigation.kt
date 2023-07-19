package com.example.europaplus.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.europaplus.ui.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RootNavRoutes.HomeScreen.route
    ){
        navigation(
            startDestination = RootNavRoutes.HomeScreen.Destination.route,
            route = RootNavRoutes.HomeScreen.route
        ){
            composable(RootNavRoutes.HomeScreen.Destination.route){
                HomeScreen(navController)
            }
        }
    }
}