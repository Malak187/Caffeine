package com.example.caffeine.ui.screens.coffee_order.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.screens.coffee_order.CoffeeOrderState
import com.example.caffeine.ui.screens.coffee_order.CoffeeSize
import com.example.caffeine.ui.shared.noRippleClickable

@Composable
fun CoffeeSizes(
    uiState: CoffeeOrderState,
    onSizeClick: (CoffeeSize) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xffF5F5F5))
                .padding(vertical = 8.dp, horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SizeOption(
                size = "S",
                isSelected = uiState.coffeeType.size == CoffeeSize.SMALL,
                onClick = { onSizeClick(CoffeeSize.SMALL) }
            )
            SizeOption(
                size = "M",
                isSelected = uiState.coffeeType.size == CoffeeSize.MEDIUM,
                onClick = { onSizeClick(CoffeeSize.MEDIUM) }
            )
            SizeOption(
                size = "L",
                isSelected = uiState.coffeeType.size == CoffeeSize.LARGE,
                onClick = { onSizeClick(CoffeeSize.LARGE) }
            )

        }
    }
}


@Composable
fun SizeOption(
    size: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color(0xFF7C351B) else Color(0xffF5F5F5),
        animationSpec = tween(
            durationMillis = 800,
        ),
        label = "backgroundColor"
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White.copy(alpha = 0.87f) else Color(0xff1f1f1f).copy(
            alpha = 0.6f
        ),
        animationSpec = tween(
            durationMillis = 800,
        ),
        label = "textColor"
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .noRippleClickable { onClick() }

    ) {
        Text(
            text = size,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}


