package com.example.caffeine.ui.screens.done_coffee_screen.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.mapper.toCoffeeLid
import com.example.caffeine.mapper.toEmptyCup

@Composable
fun CoffeeDoneScreenBody(
    startAnimation: Boolean,
    coffeePhoto: Int,
    modifier: Modifier = Modifier
) {
    val lidOffsetY by animateFloatAsState(
        targetValue = if(startAnimation) -14f else -300f,
        animationSpec = tween(
            durationMillis = 700,
            easing = LinearEasing
        ),
        label = "lid_animation"
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
        ) {
            Image(
                modifier = Modifier
                    .width(244.dp)
                    .height(300.dp),
                painter = painterResource(coffeePhoto),
                contentDescription = "Coffee Cup image"
            )
            Image(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(260.dp)
                    .height(70.dp)
                    .offset(y = lidOffsetY.dp),
                painter = painterResource(coffeePhoto.toCoffeeLid(coffeePhoto)),
                contentDescription = "Coffee Cup Cover",
            )
        }

        Image(
            modifier = Modifier
                .size(64.dp)
                .offset(y = 15.dp),
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = "The Chance Coffee"
        )
    }
}