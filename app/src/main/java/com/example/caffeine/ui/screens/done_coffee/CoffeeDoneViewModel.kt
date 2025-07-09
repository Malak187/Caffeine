package com.example.caffeine.ui.screens.done_coffee

import androidx.lifecycle.ViewModel
import com.example.caffeine.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoffeeDoneViewModel: ViewModel() {
    private val _coffeePhoto = MutableStateFlow(R.drawable.im_black_coffee)
    val coffeePhoto = _coffeePhoto.asStateFlow()

    fun loadCoffeePhoto(photo: Int) {
        _coffeePhoto.value = photo
    }
}