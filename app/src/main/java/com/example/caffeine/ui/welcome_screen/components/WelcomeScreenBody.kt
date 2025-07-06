package com.example.caffeine.ui.welcome_screen.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R


@Composable
fun WelcomeScreenBody(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
            .padding(bottom = 58.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val offset by infiniteTransition
            .animateFloat(
                initialValue = -10f,
                targetValue = 16f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1800),
                    repeatMode = RepeatMode.Reverse
                )
            )

        val shadowAlpha = ((offset - (-10f)) / (16f - (-10f))) // normalized [0,1]
            .coerceIn(0f, 1f)
            .let { lerp(0.6f, 1f, it) }

        Image(
            painter = painterResource(R.drawable.im_ghost),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(244.dp)
                .offset(y = offset.dp)
        )
        Image(
            painter = painterResource(R.drawable.im_shadow),
            contentDescription = null,
            modifier = Modifier.aspectRatio(6.55f)
                .offset(y = -offset.dp)
                .alpha(shadowAlpha)

        )
    }
}