package com.example.caffeine.ui.screens.coffee_order_screen

import com.example.caffeine.R

data class CoffeeOrderState(
    val coffeeType: CoffeeOrderCup = CoffeeOrderCup(
        photo = R.drawable.im_espresso,
        title = "Espresso",
        litres = CoffeeSize.MEDIUM,
        size = CoffeeSize.MEDIUM,
        beans = CoffeeBeans.LOW
    ),
    val animationKey: Int = 0,
    val isAnimatingDown: Boolean = false
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

enum class CoffeeBeans(val index: Int) {
    LOW(0),
    MEDIUM(1),
    HIGH(2)
}

