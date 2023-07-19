package com.example.europaplus.ui.navigation

sealed class RootNavRoutes(val route : String){
    object HomeScreen : RootNavRoutes("home"){
        object Destination : RootNavRoutes("home_screen")
    }
}
