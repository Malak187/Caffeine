package com.example.caffeine

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