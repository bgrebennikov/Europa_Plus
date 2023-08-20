package com.example.europaplus.ui.screens.bottomNavScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.europaplus.ui.theme.AppTheme

@Preview()
@Composable
fun NewsScreen() {

    val categoriesList = mutableListOf(
        "Все",
        "Europa Plus",
        "Week&Star",
        "Звезды",
        "Стиль жизни"
    )

    var currentCategoryIndex by remember {
        mutableStateOf(0)
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        NewsTabIndicator(
            AppTheme.colors.selectedItem,
            Modifier.tabIndicatorOffset(tabPositions[currentCategoryIndex])
        )
    }

    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        item {
            ScrollableTabRow(
                selectedTabIndex = currentCategoryIndex,
                indicator = indicator,
                edgePadding = 12.dp,
                divider = {  },
            ) {
                categoriesList.forEachIndexed { index, item ->
                    NewsTab(
                        title = item,
                        selected = index == currentCategoryIndex,
                        onClick = {
                            currentCategoryIndex = index
                        })
                }
            }
        }

        items(20){
            NewsPost(
                Modifier.padding(vertical = 12.dp)
            )
        }

    }
}