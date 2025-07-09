package com.example.caffeine.ui.screens.pick_snack.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.caffeine.ui.modifier.dropShadow
import com.example.caffeine.ui.modifier.noRippleClickable
import kotlin.math.abs

@Composable
fun SnackPickerPager(
    snacks: List<Int>,
    onSnackClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { snacks.size })
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    VerticalPager(
        state = pagerState,
        modifier = modifier
            .padding(top = 12.dp)
            .fillMaxSize()
            .offset(x = -screenWidth * 0.2f),
        contentPadding = PaddingValues(vertical = screenHeight * 0.25f),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(400)
        )
    ) { page ->

        val pageOffset =
            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = when {
            abs(pageOffset) < 0.001f -> 1f
            pageOffset < -1f -> 0.9f.coerceAtLeast(1f - (0.1f * abs(pageOffset)))
            pageOffset < 0f -> 1f - (0.1f * abs(pageOffset))
            else -> 1f - (0.2f * abs(pageOffset))
        }

        val rotation = when {
            abs(pageOffset) < 0.01f -> 0f
            pageOffset < -1f -> lerp(
                -4f * -1f,
                -4f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> -8f * pageOffset
            else -> -8f * pageOffset
        }

        val offsetX = when {
            pageOffset < -1f -> lerp(
                screenWidth.value * 0.4f * -1f,
                screenWidth.value * 0.8f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> screenWidth.value * 0.4f * pageOffset
            else -> -screenWidth.value * 0.5f * pageOffset
        }

        val offsetY = when {
            pageOffset < -2f -> lerp(
                screenHeight.value * 0.06f * -2f,
                screenHeight.value * 0.3f * -3f,
                (pageOffset + 2f) / -1f
            )

            pageOffset < 0f -> screenHeight.value * 0.008f * pageOffset
            pageOffset > 2f -> lerp(
                screenHeight.value * 0.3f * 2f,
                screenHeight.value * 0.5f * 3f,
                (pageOffset - 2f) / 1f
            )

            else -> screenHeight.value * 0.3f * pageOffset
        }


        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale * 1.1f
                    scaleY = scale * 1.1f
                    rotationZ = rotation
                    translationX = offsetX
                    translationY = offsetY
                }
                .size(
                    width = screenWidth * 0.7f,
                    height = screenHeight * 0.4f
                )
                .dropShadow(
                    shape = RoundedCornerShape(bottomEnd = 32.dp, topEnd = 32.dp),
                    color = Color.Black,
                    alpha = 0.12f,
                    blur = 8.dp,
                    offsetY = 4.dp,
                    offsetX = 0.dp,
                    spread = 0.dp
                )
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(bottomEnd = 32.dp, topEnd = 32.dp)
                )
                .noRippleClickable {
                    onSnackClick(snacks[page])
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(snacks[page]),
                contentDescription = "Snack",
                modifier = Modifier
                    .size(
                        width = screenWidth * 0.5f,
                        height = screenHeight * 0.2f
                    )
                    .then(
                        if (page != 1) Modifier.rotate(-8f)
                        else Modifier

                    )
            )
        }
    }
}