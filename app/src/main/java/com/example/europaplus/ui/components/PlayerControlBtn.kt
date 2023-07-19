package com.example.europaplus.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.europaplus.R
import com.example.europaplus.ui.theme.AppTheme


@Composable
fun PlayerControlBtn(
    size: Dp = 50.dp,
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colors.controlBtnBackground,
    onCLick: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .size(size = size),
        shape = RoundedCornerShape(12.dp),
        onClick = onCLick,
        colors = buttonColors(
            containerColor = backgroundColor
        ),
        contentPadding = PaddingValues(0.dp)
    ) {

        Icon(
            modifier = Modifier.size(size = size / 2),
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.White,
        )
    }
}