package com.example.europaplus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults.itemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.europaplus.R
import com.example.europaplus.ui.data.models.StationItem
import com.example.europaplus.ui.theme.AppTheme

@Preview()
@Composable
fun StationsDropdown(
    isExpanded: Boolean = true,
    paddingValues: PaddingValues = PaddingValues(),
    items: List<StationItem> = listOf(),
    onItemSelected: (StationItem) -> Unit = {},
    onDismiss: () -> Unit = {}
) {

    val selectedItemHash = remember {
        mutableIntStateOf(0)
    }

    Column(
        Modifier.offset(
            0.dp,
            paddingValues.calculateBottomPadding() - paddingValues.calculateTopPadding() - 6.dp
        )
    ) {
        DropdownMenu(
            expanded = isExpanded,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(12.dp),
            onDismissRequest = onDismiss,
        ) {

            items.forEach { station ->
                val isSelected = selectedItemHash.intValue == station.hashCode()
                DropdownMenuItem(
                    text = {
                        Column() {
                            Box() {
                                if (isSelected) Icon(
                                    imageVector =
                                    ImageVector.vectorResource(R.drawable.play),
                                    contentDescription = null,
                                    tint = AppTheme.colors.controlBtnBackground,
                                    modifier = Modifier.padding(18.dp)
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(18.dp),
                                    text = station.title,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = if (isSelected) {
                                        Color.Red
                                    } else AppTheme.colors.text
                                )
                            }
                        }
                    },
                    onClick = {
                        onItemSelected(station)
                        selectedItemHash.intValue = station.hashCode()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    colors = itemColors(
                        textColor = AppTheme.colors.text,
                    )
                )
            }

        }
    }

}