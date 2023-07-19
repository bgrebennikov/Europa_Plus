package com.example.europaplus.ui.screens.bottomNavScreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.europaplus.R
import com.example.europaplus.ui.components.PlayerControlBtn
import com.example.europaplus.ui.data.testPlaylistItems
import com.example.europaplus.ui.ext.advancedShadow
import com.example.europaplus.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ListenScreen() {

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {

        item {
            Column {
                Box(
                    modifier = Modifier
                        .padding(
                            start = 28.dp,
                            end = 28.dp,
                            top = 0.dp,
                            bottom = 24.dp
                        )
                        .fillMaxWidth()
                        .advancedShadow(
                            color = AppTheme.colors.shadowLow,
                            borderRadius = 12.dp,
                            blurRadius = 30.dp,
                            offsetY = 30.dp,
                            offsetX = 0.dp,
                            spread = 30f
                        )
                        .clip(
                            RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.test_cover
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(
                                RoundedCornerShape(12.dp)
                            ),
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp)
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .combinedClickable(
                            onClick = {},
                            onLongClick = {

                            }
                        )
                ) {
                    Text(
                        text = "Robin Shulz",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                    Text(text = "In Your Eyes (feat. Alida)", color = AppTheme.colors.textSecondary)

                }


                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(28.dp)
                        .fillMaxWidth()
                ) {

                    // Change audio stream quality
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.hq),
                            contentDescription = null,
                            tint = AppTheme.colors.textSecondary
                        )
                    }

                    PlayerControlBtn(
                        imageVector = ImageVector.vectorResource(
                            R.drawable.rewind
                        ),
                        onCLick = {

                        },
                        backgroundColor = AppTheme.colors.controlBtnBackground
                    )

                    PlayerControlBtn(
                        size = 75.dp,
                        imageVector = ImageVector.vectorResource(
                            R.drawable.play
                        ),
                        onCLick = {

                        },
                        backgroundColor = AppTheme.colors.controlBtnBackground
                    )

                    PlayerControlBtn(
                        imageVector = ImageVector.vectorResource(
                            R.drawable.fast_fwd
                        ),
                        onCLick = {

                        },
                        backgroundColor = AppTheme.colors.controlBtnBackground
                    )

                    // Show bottom sheet options
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.dots_vertical),
                            contentDescription = null,
                            tint = AppTheme.colors.textSecondary
                        )
                    }

                }

                Divider(
//                    Modifier.padding(
//                        vertical = 32.dp,
//                        horizontal = 28.dp
//                    ),
                    Modifier.padding(
                        start = 28.dp,
                        end = 28.dp,
                        top = 28.dp,
                        bottom = 28.dp
                    ),
                    color = AppTheme.colors.divider
                )
            }
        }

        items(testPlaylistItems) { song ->

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 6.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .clickable {

                    }
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.test_cover),
                    contentDescription = null,
                    Modifier
                        .size(65.dp)
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                )
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp)
                        .weight(5f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    if (song.willPlayNext) {
                        Text(
                            text = stringResource(id = R.string.next),
                            color = Color.Blue,
                            fontSize = 12.sp,
                            lineHeight = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        text = song.artist,
                        color = AppTheme.colors.text,
                        fontSize = 16.sp,
                        lineHeight = 16.sp
                    )

                    Text(
                        text = song.title,
                        color = AppTheme.colors.textSecondary,
                        fontSize = 14.sp,
                        lineHeight = 14.sp
                    )

                }

                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {

                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.dots_vertical),
                        contentDescription = null
                    )
                }

            }

        }


    }
}