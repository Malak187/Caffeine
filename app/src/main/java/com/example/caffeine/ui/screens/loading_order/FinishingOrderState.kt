package com.example.caffeine.ui.screens.loading_order

import com.example.caffeine.R
import com.example.caffeine.ui.screens.coffee_order.CoffeeBeans
import com.example.caffeine.ui.screens.coffee_order.CoffeeOrderCup
import com.example.caffeine.ui.screens.coffee_order.CoffeeSize

data class FinishingOrderState (
    val coffeeType: CoffeeOrderCup= CoffeeOrderCup(
        photo = R.drawable.im_espresso,
        title = "Espresso",
        litres = CoffeeSize.MEDIUM,
        size = CoffeeSize.MEDIUM,
        beans = CoffeeBeans.LOW
    )
)