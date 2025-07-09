package com.example.caffeine.ui.screens.loading_order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.screens.coffee_order.CoffeeSize
import com.example.caffeine.ui.screens.loading_order.components.FinishingOrderScreenFooter
import com.example.caffeine.ui.shared.CoffeeOrderScreenBody

@Composable
fun FinishingOrderScreen(
    onAnimationComplete: () -> Unit,
    uiState: FinishingOrderState,
    modifier: Modifier = Modifier
) {
    val cupHeight = when (uiState.coffeeType.size) {
        CoffeeSize.SMALL -> 188.dp
        CoffeeSize.MEDIUM -> 244.dp
        CoffeeSize.LARGE -> 300.dp
    }
    val cupWidth = when (uiState.coffeeType.size) {
        CoffeeSize.SMALL -> 152.dp
        CoffeeSize.MEDIUM -> 200.dp
        CoffeeSize.LARGE -> 244.dp
    }
    val logoSize = when (uiState.coffeeType.size) {
        CoffeeSize.SMALL -> 40.dp
        CoffeeSize.MEDIUM -> 64.dp
        CoffeeSize.LARGE -> 64.dp
    }
    Box(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
                .padding(top = 108.dp)
        ) {
            CoffeeOrderScreenBody(
                coffeePhoto = uiState.coffeeType.photo,
                coffeeTitle = uiState.coffeeType.title,
                coffeeLitres = uiState.coffeeType.litres,
                cupHeight = cupHeight,
                cupWidth = cupWidth,
                logoSize = logoSize,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            FinishingOrderScreenFooter(
                onAnimationComplete = onAnimationComplete,
            )
        }
    }
}