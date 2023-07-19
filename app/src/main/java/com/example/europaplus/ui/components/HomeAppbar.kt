package com.example.europaplus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.europaplus.R
import com.example.europaplus.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppbar(
    onExpandClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.padding(vertical = 6.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            MaterialTheme.colorScheme.background
        ),
        title = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .clickable {
                        onExpandClick()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier.height(26.dp),
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 12.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.chevron_down),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Europa Plus",
                        lineHeight = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        modifier = Modifier.padding(start = 12.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.chevron_down),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                }
                Text(
                    text = stringResource(id = R.string.appbar_subtitle),
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    color = AppTheme.colors.textSecondary
                )
            }
        })
}
