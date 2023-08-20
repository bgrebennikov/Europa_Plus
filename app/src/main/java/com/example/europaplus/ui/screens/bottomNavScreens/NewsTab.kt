package com.example.europaplus.ui.screens.bottomNavScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.europaplus.ui.theme.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Preview
@Composable
fun NewsTab(
    title: String = "Europa Plus",
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember {
        object : MutableInteractionSource {
            override val interactions: Flow<Interaction>
                get() = emptyFlow()

            override suspend fun emit(interaction: Interaction) {}

            override fun tryEmit(interaction: Interaction): Boolean {
                return true
            }

        }
    }

    Tab(
        selected = selected,
        onClick = onClick,
        interactionSource = interactionSource
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = if (selected) Color.White
                else AppTheme.colors.textSecondary
            )

        }
    }
}