package com.example.caffeine.ui.shared

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeSize

@Composable
fun CoffeeOrderScreenBody(
    coffeePhoto: Int,
    coffeeTitle: String,
    coffeeLitres: CoffeeSize,
    cupHeight: Dp,
    cupWidth: Dp,
    logoSize: Dp,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .height(336.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .height(cupHeight)
                .width(cupWidth), // Apply width here
            painter = painterResource(coffeePhoto),
            contentDescription = coffeeTitle
        )

        Image(
            modifier = Modifier
                .size(logoSize)
                .offset(y = 15.dp),
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = "The Chance Coffee"
        )
        AnimatedContent(
            targetState = coffeeLitres,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 1200,
                        easing = FastOutSlowInEasing
                    )
                ) togetherWith fadeOut(
                    animationSpec = tween(
                        durationMillis = 1200,
                        easing = FastOutSlowInEasing
                    )
                )
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 16.dp),
            label = "litresAnimation"
        ) { cupSize ->
            Text(
                text = "${cupSize.litres} ML",
                style = MaterialTheme.typography.displaySmall,
                color = Color.Black.copy(alpha = 0.6f),
            )
        }

    }
}
