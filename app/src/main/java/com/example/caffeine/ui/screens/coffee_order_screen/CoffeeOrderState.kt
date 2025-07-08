package com.example.caffeine.ui.screens.coffee_order_screen

import com.example.caffeine.R
import com.example.caffeine.ui.screens.home_screen.CoffeeCup

data class CoffeeOrderState(
    val coffeeType: CoffeeOrderCup = CoffeeOrderCup(
        photo = R.drawable.im_espresso,
        title = "Espresso",
        litres = CoffeeSize.MEDIUM,
        size = CoffeeSize.MEDIUM,
        beans = CoffeeBeans.LOW
    )
)


data class CoffeeOrderCup(
    val photo: Int,
    val title: String,
    val litres: CoffeeSize,
    val size: CoffeeSize,
    val beans: CoffeeBeans
)

enum class CoffeeSize(val litres: Int) {
    SMALL(150),
    MEDIUM(200),
    LARGE(400)
}

enum class CoffeeBeans {
    LOW,
    MEDIUM,
    HIGH
}

