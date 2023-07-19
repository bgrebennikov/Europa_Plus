package com.example.europaplus.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.europaplus.R
import com.example.europaplus.ui.components.BottomNavigationBar
import com.example.europaplus.ui.components.HomeAppbar
import com.example.europaplus.ui.components.StationsDropdown
import com.example.europaplus.ui.data.models.BottomNavigationItem
import com.example.europaplus.ui.data.stationsList
import com.example.europaplus.ui.ext.advancedShadow
import com.example.europaplus.ui.navigation.BottomNavRoutes
import com.example.europaplus.ui.navigation.BottomNavigation
import com.example.europaplus.ui.theme.AppTheme


@Preview(showSystemUi = true)
@Composable
fun HomeScreen(
    rootNavController: NavController = rememberNavController()
) {

    val bottomNavController = rememberNavController()

    val isExpanded = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            HomeAppbar(){
                isExpanded.value = !isExpanded.value
            }
        },
        bottomBar = {
            BottomNavigationBar(rootNavController = bottomNavController,
                modifier = Modifier.advancedShadow(
                    color = AppTheme.colors.shadow,
                    blurRadius = 80.dp,
                    offsetX = 0.dp,
                    offsetY = (-12).dp,
                    spread = -9f
                ),
                items = listOf(
                    BottomNavigationItem(
                        title = stringResource(id = R.string.news_title),
                        icon = ImageVector.vectorResource(
                            R.drawable.news
                        ),
                        route = BottomNavRoutes.NewsScreen.Destination.route
                    ),
                    BottomNavigationItem(
                        title = stringResource(id = R.string.charts_title),
                        icon = ImageVector.vectorResource(
                            R.drawable.fire
                        ),
                        route = BottomNavRoutes.ChartsScreen.Destination.route
                    ),
                    BottomNavigationItem(
                        title = stringResource(id = R.string.listen_title),
                        icon = ImageVector.vectorResource(
                            R.drawable.listen
                        ),
                        route = BottomNavRoutes.ListenScreen.Destination.route
                    ),
                    BottomNavigationItem(
                        title = stringResource(id = R.string.podcasts_title),
                        icon = ImageVector.vectorResource(
                            R.drawable.microphone
                        ),
                        route = BottomNavRoutes.PodcastsScreen.Destination.route
                    ),
                    BottomNavigationItem(
                        title = stringResource(id = R.string.more_title),
                        icon = ImageVector.vectorResource(
                            R.drawable.menu
                        ),
                        route = BottomNavRoutes.MoreScreen.Destination.route
                    )
                ),
                onClick = {
                    bottomNavController.navigate(it.route)
                }
            )
        }
    ) { paddingValues ->
        Column(
            Modifier.padding(paddingValues)
        ) {
            StationsDropdown(
                isExpanded = isExpanded.value,
                paddingValues = paddingValues,
                items = stationsList,
                onItemSelected = {
                    isExpanded.value = !isExpanded.value
                },
                onDismiss = {
                    isExpanded.value = !isExpanded.value
                }
            )
            BottomNavigation(rootNavController, bottomNavController)
        }
    }
}