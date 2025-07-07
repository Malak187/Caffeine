package com.example.caffeine.ui.screens.welcome_screen.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun WelcomeScreenTitle(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val alphaPositive by infiniteTransition
        .animateFloat(
            initialValue = 0.2f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(500),
                repeatMode = RepeatMode.Reverse
            )
        )

    val alphaNegative by infiniteTransition
        .animateFloat(
            initialValue = 1f,
            targetValue = 0.2f,
            animationSpec = infiniteRepeatable(
                animation = tween(500),
                repeatMode = RepeatMode.Reverse
            )
        )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Hocus",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
            )
            Image(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .offset(x = 84.dp, y = (-10).dp)
                    .alpha(alphaPositive)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .offset(x = -(80).dp, y = (-4).dp)
                    .alpha(alphaNegative)
            )
            Text(
                text = "Pocus",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
            )

        }
        Text(
            text = "I Need Coffee",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "to Focus",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
            )
            Image(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .offset(x = 100.dp, y = 16.dp)
                    .alpha(alphaPositive)
            )
        }

    }
//        Image(
//            painter = painterResource(R.drawable.ic_star),
//            contentDescription = null,
//            modifier = Modifier
//                .align(Alignment.End)
//                .size(16.dp)
//                .alpha(alpha)
//        )
}
