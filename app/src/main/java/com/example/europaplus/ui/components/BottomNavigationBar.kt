package com.example.europaplus.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.europaplus.R
import com.example.europaplus.ui.data.models.BottomNavigationItem
import com.example.europaplus.ui.ext.advancedShadow
import com.example.europaplus.ui.navigation.BottomNavRoutes
import com.example.europaplus.ui.theme.AppTheme

@Composable
//@Preview(showBackground = true)
fun BottomNavigationBar(
    items: List<BottomNavigationItem> = listOf(
        BottomNavigationItem(
            title = stringResource(id = R.string.listen_title),
            icon = ImageVector.vectorResource(
                R.drawable.listen
            ),
            route = BottomNavRoutes.ListenScreen.Destination.route
        )

    ),
    rootNavController: NavController,
    modifier: Modifier = Modifier,
    onClick: (BottomNavigationItem) -> Unit = {}
) {

    val backStackEntry = rootNavController.currentBackStackEntryAsState()

    val context = LocalContext.current

    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = AppTheme.colors.text,
    ) {

        items.forEach { currentItem ->
            val isSelected =
                currentItem.route == backStackEntry.value?.destination
                    ?.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) onClick(currentItem)
                },
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(
                            imageVector = currentItem.icon,
                            contentDescription = currentItem.title
                        )
                    }
                },
                label = {
                    Text(
                        text = currentItem.title
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = AppTheme.colors.selectedItem,
                    selectedTextColor = AppTheme.colors.selectedItem,
                    selectedIndicatorColor = MaterialTheme.colorScheme.background,
                    unselectedIconColor = AppTheme.colors.unselectedItem,
                    unselectedTextColor = AppTheme.colors.unselectedItem,
                    disabledIconColor = AppTheme.colors.unselectedItem,
                    disabledTextColor = AppTheme.colors.unselectedItem
                )
            )


        }
    }

}