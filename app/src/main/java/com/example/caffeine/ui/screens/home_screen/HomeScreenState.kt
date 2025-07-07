package com.example.caffeine.ui.screens.home_screen

data class HomeScreenState(
    val coffeeCups: List<CoffeeCups> = emptyList()
)

data class CoffeeCups(
    val title: String,
    val photo: Int,
)
