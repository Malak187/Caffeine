package com.example.caffeine.ui.home_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.home_screen.HomeScreenState
import kotlin.math.absoluteValue

@Composable
fun HomeScreenBody(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
) {
    val pagerState = rememberPagerState(
       initialPage =  uiState.coffeeCups.lastIndex,
        pageCount = {
            uiState.coffeeCups.size
        }
    )

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(
            horizontal = 60.dp
        ),

        modifier = modifier
            .padding(bottom = 100.dp)
            .clipToBounds()
    ) { index ->
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = uiState.coffeeCups[index].photo
                ),
                contentDescription = uiState.coffeeCups[index].title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(width = 200.dp)
                    .height(244.dp)
            )
            Text(
                text = uiState.coffeeCups[index].title,
                style = MaterialTheme.typography.labelLarge,
                color = Color(0xFF1F1F1F),
            )
        }
    }
}