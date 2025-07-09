package com.example.caffeine.ui.screens.done_coffee.components

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.modifier.noRippleClickable

@Composable
fun CoffeeSwitchButton(
    isOn: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val animatedOffset by animateFloatAsState(
        targetValue = if (isOn) 1f else 0f,
        animationSpec = tween(
            durationMillis = 400,
            easing = CubicBezierEasing(0.175f, 0.885f, 0.32f, 1.275f)
        ),
        label = "switch_animation"
    )
    Row(
        modifier = modifier
            .width(78.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(100.dp))
            .noRippleClickable { onToggle(!isOn) },
        horizontalArrangement = Arrangement.Center
    ) {
        Box{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = if (isOn) Color(0xFF7C351B) else Color(0xFFFFEEE7),)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp),
                contentAlignment = if (isOn) Alignment.CenterEnd else Alignment.CenterStart
            ) {
                Text(
                    text = if (isOn) "ON" else "OFF",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (isOn) Color.White.copy(alpha = 0.6f) else Color.Black.copy(alpha = 0.6f),
                )
            }

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .offset(x = -(animatedOffset * 38).dp)
                    .align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(R.drawable.im_coffee_toggle),
                    contentDescription = "Coffee toggle",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
