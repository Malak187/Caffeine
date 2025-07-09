package com.example.caffeine.ui.screens.home

data class HomeScreenState(
    val coffeeCups: List<CoffeeCup> = emptyList(),
    val selectedCupIndex: Int = 0
)

data class CoffeeCup(
    val title: String,
    val photo: Int,
)
