package com.example.caffeine.ui.screens.home.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.home.CoffeeCup
import com.example.caffeine.ui.screens.home.HomeScreenState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenBody(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    onCupSelected: (Int) -> Unit
) {
    val pagerState = rememberPagerState { uiState.coffeeCups.size }

    LaunchedEffect(pagerState.currentPage) {
        onCupSelected(pagerState.currentPage)
    }

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {

        HorizontalPager(
            modifier = modifier
                .padding(bottom = 100.dp)
                .height(300.dp)
                .clipToBounds(),
            contentPadding = PaddingValues(horizontal = 68.dp),
            pageSpacing = (-30).dp,
            state = pagerState,
        ) { pageIndex ->
            CoffeeTypeItem(
                modifier = Modifier.fillMaxWidth(),
                coffeeType = uiState.coffeeCups[pageIndex],
                pagerState = pagerState,
                pageIndex = pageIndex
            )
        }
    }
}

@Composable
private fun CoffeeTypeItem(
    modifier: Modifier = Modifier,
    coffeeType: CoffeeCup,
    pagerState: PagerState,
    pageIndex: Int
) {

    val pageOffset = (pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction
    val easedOffset = FastOutSlowInEasing.transform(pageOffset.absoluteValue.coerceIn(0f, 1f))

    val scale = lerp(
        start = 0.61f,
        stop = 1f,
        fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
    )

    val verticalOffset = if (pageOffset.absoluteValue > 0.1f) {
        lerp(0f, 100f, easedOffset)
    } else 0f

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationY = verticalOffset
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(coffeeType.photo),
                contentDescription = coffeeType.title
            )
            Image(
                modifier = Modifier
                    .size(66.dp)
                    .offset(y = 15.dp),
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "The Chance Coffee"
            )
        }
        Text(
            text = coffeeType.title,
            style = MaterialTheme.typography.labelLarge,
            color = Color(0xFF1F1F1F),
        )
    }
}