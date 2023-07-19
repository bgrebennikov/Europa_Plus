package com.example.europaplus.ui.navigation

sealed class BottomNavRoutes(val route: String){
    object NewsScreen : BottomNavRoutes("news"){
        object Destination: BottomNavRoutes("news_screen")
    }

    object ChartsScreen : BottomNavRoutes("charts"){
        object Destination: BottomNavRoutes("charts_screen")
    }

    object ListenScreen : BottomNavRoutes("listen"){
        object Destination: BottomNavRoutes("listen_screen")
    }

    object PodcastsScreen : BottomNavRoutes("podcasts"){
        object Destination: BottomNavRoutes("podcasts_screen")
    }

    object MoreScreen : BottomNavRoutes("more"){
        object Destination: BottomNavRoutes("more_screen")
    }
}
