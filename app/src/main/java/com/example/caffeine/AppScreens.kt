package com.example.caffeine

import com.example.caffeine.ui.screens.coffee_order.CoffeeSize
import kotlinx.serialization.Serializable

@Serializable
object WelcomeNavScreen

@Serializable
object HomeNavScreen

@Serializable
data class CoffeeOrderNavScreen(
    val title: String,
    val photo: Int
)

@Serializable
data class FinishingOrderNavScreen(
    val photo: Int,
    val size: CoffeeSize,
    val litres: CoffeeSize,
)

@Serializable
data class CoffeeDoneNavScreen(
    val photo: Int,
)

@Serializable
object SnackPickerNavScreen

@Serializable
data class SnackDoneNavScreen(
    val photo: Int,

)