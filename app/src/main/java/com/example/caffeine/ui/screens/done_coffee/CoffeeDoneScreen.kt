package com.example.caffeine.ui.screens.done_coffee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.done_coffee.components.CoffeeDoneScreenBody
import com.example.caffeine.ui.screens.done_coffee.components.CoffeeDoneScreenHeader
import com.example.caffeine.ui.screens.done_coffee.components.CoffeeSwitchButton
import com.example.caffeine.ui.shared.ScreenFooter
import com.example.caffeine.ui.theme.CaffeineTheme

@Composable
fun CoffeeDoneScreen(
    onButtonClick: () -> Unit,
    onClosesClick: () -> Unit,
    coffeePhoto: Int,
    modifier: Modifier = Modifier
) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        CoffeeDoneScreenHeader(
            onCloseClick = onClosesClick,
            startAnimation = startAnimation,
        )
        CoffeeDoneScreenBody(
            startAnimation = startAnimation,
            coffeePhoto = coffeePhoto,
            modifier = Modifier.padding(bottom = 48.dp)
        )
        var isCoffeeOn by remember { mutableStateOf(false) }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CoffeeSwitchButton(
                isOn = isCoffeeOn,
                onToggle = { isCoffeeOn = it },
                modifier = Modifier
                    .padding(end = 8.dp)
            )
            Text(
                text = "Take Away",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xff1f1f1f).copy(alpha = 0.7f),
                modifier = Modifier
            )
        }
        ScreenFooter(
            startAnimation = startAnimation,
            isAnimated = true,
            buttonText = "Take snack",
            buttonIcon = painterResource(R.drawable.ic_continue),
            onClick = onButtonClick
        )
    }
}

@Preview
@Composable
private fun CoffeeDonePrev() {
    CaffeineTheme {
        CoffeeDoneScreen(
            {},
            {},
            R.drawable.macchiato_empty_cup,
            modifier = Modifier
        )
    }
}