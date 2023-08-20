package com.example.europaplus.ui.screens.bottomNavScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.europaplus.ui.theme.AppTheme

@Composable
fun NewsTabIndicator(
    color: Color = AppTheme.colors.selectedItem,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color, RoundedCornerShape(50.dp))
            .zIndex(-1f)
    )
}