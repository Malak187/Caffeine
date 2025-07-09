package com.example.caffeine.ui.screens.loading_order.components

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun FinishingOrderScreenFooter(
    onAnimationComplete: () -> Unit,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedWavyLine(
            onAnimationComplete = onAnimationComplete,
            modifier = Modifier
                .padding(vertical = 32.dp)
        )
        Text(
            text = "Almost Done",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xff1f1f1f).copy(alpha = 0.87f),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = "Your coffee will be finish in",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xff1f1f1f).copy(alpha = 0.6f),
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.im_coffee),
            contentDescription = "Coffee timer",
        )
    }
}

@Composable
fun AnimatedWavyLine(
    onAnimationComplete: () -> Unit,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 1.5.dp,
    amplitude: Float = 30f,
    frequency: Float = 0.0075f,
) {
    var drawAnimationProgress by remember { mutableFloatStateOf(0f) }
    var eraseAnimationProgress by remember { mutableFloatStateOf(0f) }

    val animatedDrawProgress by animateFloatAsState(
        targetValue = drawAnimationProgress,
        animationSpec = tween(
            durationMillis = 3000,
            easing = FastOutLinearInEasing
        ),
        label = "waveDrawProgress"
    )

    val animatedEraseProgress by animateFloatAsState(
        targetValue = eraseAnimationProgress,
        animationSpec = tween(
            durationMillis = 1500,
            easing = LinearEasing
        ),
        finishedListener = { finalValue ->
            // Trigger callback when erasing animation completes
            if (finalValue == 1f) {
                onAnimationComplete()
            }
        },
        label = "waveEraseProgress"
    )

    LaunchedEffect(Unit) {
        drawAnimationProgress = 1f

        delay(3500)
        eraseAnimationProgress = 1f
    }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val centerY = canvasHeight / 2

        val drawWidth = canvasWidth * animatedDrawProgress

        val wavePath = Path().apply {
            moveTo(0f, centerY)
            for (x in 0..drawWidth.toInt()) {
                val y = centerY + amplitude * sin(x * frequency * PI).toFloat()
                lineTo(x.toFloat(), y)
            }
        }

        drawPath(
            path = wavePath,
            color = Color(0xFF1F1F1F),
            style = Stroke(width = strokeWidth.toPx())
        )

        if (animatedEraseProgress > 0f) {
            val eraseWidth = canvasWidth * 0.4f * animatedEraseProgress
            val startX = canvasWidth - eraseWidth

            val eraserPath = Path().apply {
                moveTo(startX, centerY)
                for (x in startX.toInt()..canvasWidth.toInt()) {
                    val y = centerY + amplitude * sin(x * frequency * PI).toFloat()
                    lineTo(x.toFloat(), y)
                }
            }

            drawPath(
                path = eraserPath,
                color = Color.White,
                style = Stroke(width = strokeWidth.toPx() + 4f)
            )
        }
    }
}
