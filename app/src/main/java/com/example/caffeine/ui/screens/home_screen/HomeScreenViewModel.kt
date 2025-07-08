package com.example.caffeine.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import com.example.caffeine.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel : ViewModel(), HomeScreenInteractionListener {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    init {
        loadCoffeeCups()
    }

    private fun loadCoffeeCups() {
        _state.update {
            it.copy(
                coffeeCups = listOf(
                    CoffeeCup(
                        title = "Espresso",
                        photo = (R.drawable.im_espresso_coffee)
                    ),
                    CoffeeCup(
                        title = "Macchiato",
                        photo = (R.drawable.im_macchiato_coffee)
                    ),
                    CoffeeCup(
                        title = "Latte",
                        photo = (R.drawable.im_lattee_coffee)
                    ),
                    CoffeeCup(
                        title = "Black",
                        photo = (R.drawable.im_black_coffee)
                    ),
                )
            )
        }
    }

    override fun onCupSelected(index: Int) {
        _state.update {
            it.copy(
                selectedCupIndex = index
            )
        }
    }
}