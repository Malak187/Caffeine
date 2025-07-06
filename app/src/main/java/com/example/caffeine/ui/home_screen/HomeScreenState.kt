package com.example.caffeine.ui.home_screen

import androidx.compose.ui.graphics.painter.Painter

data class HomeScreenState(
    val coffeeCups: List<CoffeeCups> = emptyList()
)

data class CoffeeCups(
    val title: String,
    val photo: Int,
)
