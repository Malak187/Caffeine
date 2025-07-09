package com.example.caffeine.ui.screens.coffee_order_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R


@Composable
fun CoffeeOrderScreenHeader(
    modifier: Modifier = Modifier,
    onGoBackClick: () -> Unit ,
    title: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F5F5))
                .clickable { onGoBackClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_go_back),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF1F1F1F).copy(alpha = 0.87f)
        )

    }
}