package com.example.caffeine.ui.screens.coffee_order

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.coffee_order.components.CoffeeBeans
import com.example.caffeine.ui.shared.CoffeeOrderScreenBody
import com.example.caffeine.ui.screens.coffee_order.components.CoffeeOrderScreenHeader
import com.example.caffeine.ui.screens.coffee_order.components.CoffeeSizes
import com.example.caffeine.ui.shared.ScreenFooter
import kotlinx.coroutines.launch

@Composable
fun CoffeeOrderScreen(
    onGoBackClick: () -> Unit,
    uiState: CoffeeOrderState,
    onButtonClick: () -> Unit,
    listener: CoffeeOrderInteractionListener,
    modifier: Modifier = Modifier
) {
    val animatedCupHeight by animateDpAsState(
        targetValue = when (uiState.coffeeType.size) {
            CoffeeSize.SMALL -> 188.dp
            CoffeeSize.MEDIUM -> 244.dp
            CoffeeSize.LARGE -> 300.dp
        },
        animationSpec = tween(1000),
    )
    val offsetY = remember { Animatable(0f) }
    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(1f) }

    val animatedCupWidth by animateDpAsState(
        targetValue = when (uiState.coffeeType.size) {
            CoffeeSize.SMALL -> 152.dp
            CoffeeSize.MEDIUM -> 200.dp
            CoffeeSize.LARGE -> 244.dp
        },
        animationSpec = tween(1000),
    )

    val animatedLogoSize by animateDpAsState(
        targetValue = when (uiState.coffeeType.size) {
            CoffeeSize.SMALL -> 40.dp
            CoffeeSize.MEDIUM -> 64.dp
            CoffeeSize.LARGE -> 64.dp
        },
        animationSpec = tween(1000),
    )

    val animatedBoxHeight by animateDpAsState(
        targetValue = when (uiState.coffeeType.size) {
            CoffeeSize.SMALL -> 200.dp
            CoffeeSize.MEDIUM -> 180.dp
            CoffeeSize.LARGE -> 160.dp
        },
        animationSpec = tween(1000),
    )


    LaunchedEffect(uiState.animationKey) {
        if (uiState.animationKey > 0) {
            if (uiState.isAnimatingDown) {
                offsetY.snapTo(-100f)
                scale.snapTo(1f)
            } else {
                offsetY.snapTo(400f)
                scale.snapTo(0.3f)
            }
            alpha.snapTo(1f)

            launch {
                offsetY.animateTo(
                    targetValue = if (uiState.isAnimatingDown) 800f else -500f,
                    animationSpec = tween(1200, easing = EaseInOut)
                )
            }
            launch {
                alpha.animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(1200, easing = EaseInOut)
                )
                alpha.snapTo(0f)
            }
            launch {
                scale.animateTo(
                    targetValue = if (uiState.isAnimatingDown) 0.3f else 1f,
                    animationSpec = tween(1200, easing = EaseInOut)
                )
            }
        }
    }
    Box(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            CoffeeOrderScreenHeader(
                title = uiState.coffeeType.title,
                onGoBackClick = onGoBackClick
            )
            CoffeeOrderScreenBody(
                coffeePhoto = uiState.coffeeType.photo,
                coffeeTitle = uiState.coffeeType.title,
                coffeeLitres = uiState.coffeeType.litres,
                cupHeight = animatedCupHeight,
                cupWidth = animatedCupWidth,
                logoSize = animatedLogoSize,
            )
            CoffeeSizes(
                uiState = uiState,
                onSizeClick = { size ->
                    listener.onCoffeeSizeSelected(size)
                }
            )
            CoffeeBeans(
                uiState = uiState,
                onCoffeeBeansClick = { beans ->
                    listener.onCoffeeBeansSelected(beans)
                }
            )

            ScreenFooter(
                buttonText = "Continue",
                buttonIcon = painterResource(R.drawable.ic_continue),
                onClick = { onButtonClick() },
            )
        }
        if (uiState.animationKey > 0 && alpha.value > 0f) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(animatedBoxHeight )
                    .align(Alignment.TopCenter)
                    .clipToBounds()
            ) {
                Image(
                    painter = painterResource(R.drawable.coffee_beans),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset { IntOffset(0, offsetY.value.toInt()) }
                        .scale(scale.value)
                        .alpha(alpha.value)
                        .size(150.dp)

                )
            }
        }
    }
}