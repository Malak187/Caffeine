package com.example.caffeine.ui.screens.coffee_order_screen.components

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
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeBeans
import com.example.caffeine.ui.screens.coffee_order_screen.CoffeeOrderState
import com.example.caffeine.ui.shared.noRippleClickable


@Composable
fun CoffeeBeans(
    uiState: CoffeeOrderState,
    onCoffeeBeansClick: (CoffeeBeans) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .height(56.dp)
                .background(Color(0xffF5F5F5))
                .padding(vertical = 8.dp, horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CoffeeBeansOption(
                isSelected = uiState.coffeeType.beans == CoffeeBeans.LOW,
                onClick = { onCoffeeBeansClick(CoffeeBeans.LOW) }
            )
            CoffeeBeansOption(
                isSelected = uiState.coffeeType.beans == CoffeeBeans.MEDIUM,
                onClick = { onCoffeeBeansClick(CoffeeBeans.MEDIUM) }
            )
            CoffeeBeansOption(
                isSelected = uiState.coffeeType.beans == CoffeeBeans.HIGH,
                onClick = { onCoffeeBeansClick(CoffeeBeans.HIGH) }
            )

        }
    }
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "Low",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xff1f1f1f).copy(alpha = 0.6f),
            modifier = Modifier.padding(end = 40.dp)
        )
        Text(
            text = "Medium",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xff1f1f1f).copy(alpha = 0.6f),
            modifier = Modifier.padding(end = 40.dp)
        )
        Text(
            text = "High",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xff1f1f1f).copy(alpha = 0.6f)
        )

    }
}


@Composable
fun CoffeeBeansOption(
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

    val iconColor by animateColorAsState(
        targetValue = if (isSelected) Color.White.copy(alpha = 0.87f) else Color(0xffF5F5F5),
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
        Icon(
            painter = painterResource(R.drawable.ic_coffee_bean),
            contentDescription = "coffeeBeans",
            tint = iconColor,
            modifier = Modifier.size(22.dp)
        )
    }
}


