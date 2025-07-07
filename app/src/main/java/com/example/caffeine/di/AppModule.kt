package com.example.caffeine.di

import com.example.caffeine.ui.screens.home_screen.HomeScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeScreenViewModel)
}