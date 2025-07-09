package com.example.caffeine.ui.screens.done_coffee_screen.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun CoffeeDoneScreenHeader(
    onCloseClick: () -> Unit,
    startAnimation: Boolean,
    modifier: Modifier = Modifier
) {
    val headerOffsetY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else -300f,
        animationSpec = tween(
            durationMillis = 700,
            easing = LinearEasing
        ),
        label = "header_animation"
    )

    val closeOffsetY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else -50f,
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearEasing
        ),
        label = "close_icon_animation"
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)

    ) {
        Box(
            modifier = Modifier
                .offset(y = closeOffsetY.dp)
                .padding(bottom = 16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F5F5))
                .clickable { onCloseClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_cancel),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }
        Box(
            modifier = Modifier
                .offset(y = headerOffsetY.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF7C351B)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_tick),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }

                Text(
                    text = "Your coffee is ready,\n" +
                            "Enjoy",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}