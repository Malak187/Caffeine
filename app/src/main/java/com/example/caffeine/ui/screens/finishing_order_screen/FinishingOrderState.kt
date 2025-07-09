package com.example.caffeine.ui.screens.finishing_order_screen

import com.example.caffeine.R
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeBeans
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeOrderCup
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeSize

data class FinishingOrderState (
    val coffeeType: CoffeeOrderCup= CoffeeOrderCup(
        photo = R.drawable.im_espresso,
        title = "Espresso",
        litres = CoffeeSize.MEDIUM,
        size = CoffeeSize.MEDIUM,
        beans = CoffeeBeans.LOW
    )
)