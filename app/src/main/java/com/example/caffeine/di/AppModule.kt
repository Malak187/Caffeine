package com.example.caffeine.di

import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeOrderViewModel
import com.example.caffeine.ui.screens.done_coffee_screen.CoffeeDoneViewModel
import com.example.caffeine.ui.screens.finishing_order_screen.FinishingOrderScreen
import com.example.caffeine.ui.screens.finishing_order_screen.FinishingOrderViewModel
import com.example.caffeine.ui.screens.home_screen.HomeScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::CoffeeOrderViewModel)
    viewModelOf(::FinishingOrderViewModel)
    viewModelOf(::CoffeeDoneViewModel)
}