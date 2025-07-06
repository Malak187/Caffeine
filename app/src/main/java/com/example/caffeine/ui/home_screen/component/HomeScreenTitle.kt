package com.example.caffeine.ui.home_screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = "Good Morning",
            style = MaterialTheme.typography.headlineLarge,
            color = Color(0xFFB3B3B3),
        )
        Row(
            modifier = Modifier.padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Malak",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF3B3B3B),
            )

            Text(
                text = "☀",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.offset(y= -(4).dp)
            )
        }
        Text(
            text = "What would you like to drink today?",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF1F1F1F).copy(alpha = 0.8f),
            modifier = Modifier.padding(bottom = 56.dp)
        )
    }
}