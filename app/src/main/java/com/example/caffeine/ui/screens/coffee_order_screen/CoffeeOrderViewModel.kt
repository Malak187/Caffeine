package com.example.caffeine.ui.screens.coffee_order_screen

import androidx.lifecycle.ViewModel
import com.example.caffeine.ui.screens.home_screen.CoffeeCup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeOrderViewModel : ViewModel(), CoffeeOrderInteractionListener {
    private val _state = MutableStateFlow(CoffeeOrderState())
    val state = _state.asStateFlow()

    fun loadCoffeeCup(
        title: String,
        photo: Int
    ) {
        _state.update {
            it.copy(
                coffeeType = CoffeeOrderCup(
                    title = title,
                    photo = photo,
                    litres = CoffeeSize.MEDIUM,
                    size = CoffeeSize.MEDIUM,
                    beans = CoffeeBeans.LOW
                )
            )
        }
    }

    override fun onCoffeeSizeSelected(size: CoffeeSize) {
        _state.update {
            it.copy(
                coffeeType = it.coffeeType.copy(size = size, litres = size),
            )
        }
    }

    override fun onCoffeeBeansSelected(beans: CoffeeBeans) {
        _state.update {
            it.copy(
                coffeeType = it.coffeeType.copy(beans = beans)
            )
        }
    }
}