package com.example.europaplus.ui.screens.bottomNavScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.europaplus.R
import com.example.europaplus.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NewsPost(
    modifier: Modifier = Modifier,
    tags: List<String> = listOf(
        "Europa Plus",
        "Новости",
        "Радио",
    ),
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(18.dp)
            )
            .background(AppTheme.colors.backgroundSecondary)
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.news_poster_test),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(),
        )
        Column(
            Modifier.padding(12.dp)
        ) {
            Text(
                text = "17 Июля 2023 в 18:40",
                color = AppTheme.colors.textSecondary,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "На Европе Плюс Самара настоящий «SUNDAY»!",
                color = AppTheme.colors.text,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                tags.forEach {
                    Text(
                        text = it,
                        modifier = Modifier
                            .background(
                                AppTheme.colors.tagsColor,
                                RoundedCornerShape(50.dp)
                            )
                            .padding(18.dp, 12.dp)
                    )
                }
            }

        }
    }
}