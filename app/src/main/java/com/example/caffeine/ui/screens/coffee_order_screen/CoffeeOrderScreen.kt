package com.example.caffeine.ui.screens.coffee_order_screen

import android.R.attr.scaleX
import android.R.attr.scaleY
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.coffee_order_screen.components.CoffeeBeans
import com.example.caffeine.ui.screens.coffee_order_screen.components.CoffeeOrderScreenBody
import com.example.caffeine.ui.screens.coffee_order_screen.components.CoffeeOrderScreenHeader
import com.example.caffeine.ui.screens.coffee_order_screen.components.CoffeeSizes
import com.example.caffeine.ui.shared.ScreenFooter

@Composable
fun CoffeeOrderScreen(
    uiState: CoffeeOrderState,
    onClick: () -> Unit,
    listener: CoffeeOrderInteractionListener,
    modifier: Modifier = Modifier
) {
    var isAnimating by remember { mutableStateOf(false) }
    var animationKey by remember { mutableStateOf(0) }
    val animatedCupHeight by animateDpAsState(
        targetValue = when (uiState.coffeeType.size) {
            CoffeeSize.SMALL -> 188.dp
            CoffeeSize.MEDIUM -> 244.dp
            CoffeeSize.LARGE -> 300.dp
        },
        animationSpec = tween(1000),
    )

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


    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .statusBarsPadding()
        ) {
            CoffeeOrderScreenHeader(
                title = uiState.coffeeType.title
            )
            CoffeeOrderScreenBody(
                uiState = uiState,
                cupHeight = animatedCupHeight,
                cupWidth = animatedCupWidth,
                logoSize = animatedLogoSize,
            )
            CoffeeSizes(
                uiState = uiState,
                onSizeClick = { listener.onCoffeeSizeSelected(it) }
            )
            CoffeeBeans(
                uiState = uiState,
                onCoffeeBeansClick = { beans ->
                    listener.onCoffeeBeansSelected(beans)
                    isAnimating = true
                    animationKey++
                }
            )

            ScreenFooter(
                buttonText = "Continue",
                buttonIcon = painterResource(R.drawable.ic_continue),
                onClick = { onClick() },
            )
        }

        if (isAnimating) {
            FallingCoffeeBeansAnimation(
                key = animationKey,
                onAnimationEnd = { isAnimating = false },
                coffeeBeansSize = animatedCupWidth - 44.dp,
            )
        }
    }
}


@Composable
fun FallingCoffeeBeansAnimation(
    coffeeBeansSize: Dp,
    key: Int,
    onAnimationEnd: () -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val animationDuration = 400

    var animationState by remember(key) { mutableStateOf(false) }

    val offsetY by animateFloatAsState(
        targetValue = if (animationState) {
            with(density) { (screenHeight * 0.15f).toPx() }
        } else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            easing = LinearEasing
        ),
        finishedListener = { onAnimationEnd() },
    )

    val alpha by animateFloatAsState(
        targetValue = if (offsetY > with(density) { (screenHeight * 0.6f).toPx() }) {
            0.2f
        } else 1f,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        ),
    )



    LaunchedEffect(key) {
        animationState = true
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.coffee_beans),
            contentDescription = "Falling coffee beans",
            modifier = Modifier
                .size(coffeeBeansSize)
                .offset(y = with(density) { offsetY.toDp() })
                .graphicsLayer {
                    this.alpha = alpha

                }
        )
    }
}