package com.example.caffeine.ui.screens.done_snack.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun SnackDoneScreenBody(
    @DrawableRes snackPhoto: Int,
    modifier: Modifier = Modifier
) {

    var animated by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animated = true
    }


    val animationState by animateFloatAsState(
        targetValue = if (animated) 1f else 0f,
        animationSpec = tween(600)
    )


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 160.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Image(
            painter = painterResource(snackPhoto),
            contentDescription = null,
            modifier = Modifier
                .size(width = 300.dp, height = 310.dp)
                .padding(
                    top = (80 * (1 - animationState)).dp,
                    end = (80 * (1 - animationState)).dp
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Bon appétit",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF1F1F1F).copy(alpha = 0.8f)
            )
            Icon(
                painter = painterResource(R.drawable.ic_magic_wand),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 8.dp),
            )
        }
    }
}