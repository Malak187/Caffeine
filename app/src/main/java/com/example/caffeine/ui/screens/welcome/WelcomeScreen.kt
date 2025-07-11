package com.example.caffeine.ui.screens.welcome

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
import com.example.caffeine.ui.shared.ScreenFooter
import com.example.caffeine.ui.shared.ScreenHeader
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.screens.welcome.components.WelcomeScreenBody
import com.example.caffeine.ui.screens.welcome.components.WelcomeScreenTitle

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ScreenHeader()
        WelcomeScreenTitle()
        WelcomeScreenBody()
        ScreenFooter(
            buttonText = "bring my coffee",
            buttonIcon = painterResource(R.drawable.ic_cup),
            onClick = { onClick() }
        )

    }
}

@Preview
@Composable
private fun WelcomeScreenPrev() {
    CaffeineTheme {
        WelcomeScreen(
            onClick = {}
        )
    }
}