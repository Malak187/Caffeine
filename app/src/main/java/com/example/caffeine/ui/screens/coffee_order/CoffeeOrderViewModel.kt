package com.example.caffeine.ui.screens.coffee_order

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.caffeine.mapper.toEmptyCup
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
                    photo = photo.toEmptyCup(photo),
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

        Log.e("Malak", "onCoffeeBeansSelected called with $beans", )

        val currentBeans = _state.value.coffeeType.beans
        println("Current beans: $currentBeans") // Debug log

        // Always update the selection, even if it's the same
        val isAnimating = beans.index > currentBeans.index

        _state.update {
            it.copy(
                coffeeType = it.coffeeType.copy(beans = beans),
                isAnimatingDown = isAnimating,
                animationKey = it.animationKey + 1
            )
        }

        Log.e("Malak", "${_state.value}") // Debug log
    }
}