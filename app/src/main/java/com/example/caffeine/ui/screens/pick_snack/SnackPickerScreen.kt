package com.example.caffeine.ui.screens.pick_snack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.ui.screens.pick_snack.components.SnackPickerPager
import com.example.caffeine.ui.screens.pick_snack.components.SnackPickerScreenHeader
import com.example.caffeine.ui.theme.CaffeineTheme

@Composable
fun SnackPickerScreen(
    snacks: List<Int>,
    onClosesClick: () -> Unit,
    onSnackClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.White)
    ) {
        SnackPickerScreenHeader(
            onCloseClick = onClosesClick,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
        )
        SnackPickerPager(
            snacks = snacks,
            onSnackClick = onSnackClick,
        )
    }
}

@Preview
@Composable
private fun SnackPickerScreenPreview() {
    CaffeineTheme {
        SnackPickerScreen(
            snacks = Snacks.snacksOptions,
            {},
            {}
        )
    }
}