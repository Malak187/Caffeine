package com.example.caffeine.ui.screens.finishing_order_screen

import androidx.lifecycle.ViewModel
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FinishingOrderViewModel : ViewModel(), FinishingOrderInteractionListener {
    private val _state = MutableStateFlow(FinishingOrderState())
    val state = _state.asStateFlow()

    fun loadCoffeeOrder(
        photo: Int,
        size: CoffeeSize,
        litres: CoffeeSize
    ) {
        _state.update { currentState ->
            currentState.copy(
                coffeeType = currentState.coffeeType.copy(
                    photo = photo,
                    size = size,
                    litres = litres
                )
            )
        }
    }
}