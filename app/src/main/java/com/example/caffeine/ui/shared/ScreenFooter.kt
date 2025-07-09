package com.example.caffeine.ui.shared

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ScreenFooter(
    modifier: Modifier = Modifier,
    startAnimation: Boolean = true,
    isAnimated: Boolean = false,
    onClick: () -> Unit,
    buttonText: String,
    buttonIcon: Painter
) {
    val buttonOffsetY by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 300f,
        animationSpec = tween(
            durationMillis = 700,
            easing = LinearEasing
        ),
        label = "button_animation"
    )
    Box(
        modifier = modifier
            .then(
                if (isAnimated) {
                    Modifier.offset(y = buttonOffsetY.dp)
                } else {
                    Modifier
                }
            )
            .fillMaxWidth()
            .padding(bottom = 32.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(100.dp),
                    clip = true
                )
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFF1F1F1F))
                .padding(vertical = 18.dp, horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White.copy(alpha = 0.87f),
                modifier = Modifier.padding(end = 8.dp)
            )
            Icon(
                painter = buttonIcon,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.87f)
            )
        }

    }
}