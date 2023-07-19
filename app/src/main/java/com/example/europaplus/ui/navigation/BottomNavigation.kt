package com.example.europaplus.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.europaplus.ui.screens.bottomNavScreens.ChartsScreen
import com.example.europaplus.ui.screens.bottomNavScreens.ListenScreen
import com.example.europaplus.ui.screens.bottomNavScreens.MoreScreen
import com.example.europaplus.ui.screens.bottomNavScreens.NewsScreen
import com.example.europaplus.ui.screens.bottomNavScreens.PodcastsScreen

@Composable
fun BottomNavigation(
    rootNavController: NavController,
    bottomNavController: NavHostController
) {

    NavHost(
        navController = bottomNavController,
        startDestination = BottomNavRoutes.ListenScreen.route
    ) {
        navigation(
            startDestination = BottomNavRoutes.ListenScreen.Destination.route,
            route = BottomNavRoutes.ListenScreen.route
        ) {
            composable(BottomNavRoutes.NewsScreen.Destination.route) {
                NewsScreen()
            }
            composable(BottomNavRoutes.ChartsScreen.Destination.route) {
                ChartsScreen()
            }
            composable(BottomNavRoutes.ListenScreen.Destination.route) {
                ListenScreen()
            }
            composable(BottomNavRoutes.PodcastsScreen.Destination.route) {
                PodcastsScreen()
            }
            composable(BottomNavRoutes.MoreScreen.Destination.route) {
                MoreScreen()
            }
        }
    }
}