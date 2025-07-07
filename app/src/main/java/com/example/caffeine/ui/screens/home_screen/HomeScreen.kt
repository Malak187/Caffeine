package com.example.caffeine.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.home_screen.component.HomeScreenBody
import com.example.caffeine.ui.screens.home_screen.component.HomeScreenTitle
import com.example.caffeine.ui.shared.ScreenFooter
import com.example.caffeine.ui.shared.ScreenHeader
import com.example.caffeine.ui.theme.CaffeineTheme

@Composable
fun HomeScreen(
    uiState: HomeScreenState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
            .statusBarsPadding()

    ) {
        ScreenHeader(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        HomeScreenTitle(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        HomeScreenBody(
            uiState = uiState,
        )
        ScreenFooter(
            buttonText = "Continue",
            buttonIcon = painterResource(R.drawable.ic_continue),
            onClick = {/*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    CaffeineTheme {
        HomeScreen(
            uiState = HomeScreenState(),
        )
    }
}
