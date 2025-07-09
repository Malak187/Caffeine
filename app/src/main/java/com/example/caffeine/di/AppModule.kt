package com.example.caffeine.di

import com.example.caffeine.ui.screens.coffee_order.CoffeeOrderViewModel
import com.example.caffeine.ui.screens.done_coffee.CoffeeDoneViewModel
import com.example.caffeine.ui.screens.done_snack.SnackDoneViewModel
import com.example.caffeine.ui.screens.loading_order.FinishingOrderViewModel
import com.example.caffeine.ui.screens.home.HomeScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::CoffeeOrderViewModel)
    viewModelOf(::FinishingOrderViewModel)
    viewModelOf(::CoffeeDoneViewModel)
    viewModelOf(::SnackDoneViewModel)
}