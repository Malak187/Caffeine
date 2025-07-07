package com.example.caffeine.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import com.example.caffeine.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    init {
        loadCoffeeCups()
    }

    private fun loadCoffeeCups() {
        _state.update {
            it.copy(
                coffeeCups = listOf(
                    CoffeeCups(
                        title = "Espresso",
                        photo = (R.drawable.im_espresso_coffee)
                    ),
                    CoffeeCups(
                        title = "Macchiato",
                        photo = (R.drawable.im_macchiato_coffee)
                    ),
                    CoffeeCups(
                        title = "Latte",
                        photo = (R.drawable.im_lattee_coffee)
                    ),
                    CoffeeCups(
                        title = "Black",
                        photo = (R.drawable.im_black_coffee)
                    ),
                )
            )
        }
    }
}