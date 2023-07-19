package com.example.europaplus.ui.data.models

data class PlaylistItem(
    val artist: String,
    val title: String,
    val coverUrl: String,
    val willPlayNext: Boolean = false
    )
