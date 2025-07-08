package com.example.caffeine.ui.screens.coffee_order_screen

interface CoffeeOrderInteractionListener {
    fun onCoffeeSizeSelected(size: CoffeeSize)
    fun onCoffeeBeansSelected(beans: CoffeeBeans)
}