package com.example.europaplus.ui.data

import com.example.europaplus.ui.data.models.PlaylistItem
import com.example.europaplus.ui.data.models.StationItem
import kotlin.random.Random

val stationsList: List<StationItem> = listOf(
    StationItem(
        title = "Europa Plus"
    ),
    StationItem(
        title = "Top 40"
    ),
    StationItem(
        title = "New"
    ),
    StationItem(
        title = "Light"
    )
)

val testPlaylistItems : MutableList<PlaylistItem> = mutableListOf<PlaylistItem>().apply {
    repeat(100){
        add(
            PlaylistItem(
                artist = "Robin Shulz ${Random.nextInt(1000, 531331535)}",
                title = "In your eyes",
                "",
                true
            )
        )
    }
}