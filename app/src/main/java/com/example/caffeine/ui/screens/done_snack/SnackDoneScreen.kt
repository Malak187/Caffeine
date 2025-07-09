package com.example.caffeine.ui.screens.done_snack

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.screens.done_snack.components.SnackDoneScreenBody
import com.example.caffeine.ui.screens.done_snack.components.SnackDoneScreenHeader
import com.example.caffeine.ui.shared.ScreenFooter

@Composable
fun SnackDoneScreen(
    onCloseClick: () -> Unit,
    @DrawableRes snackPhoto: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)

    ) {
        SnackDoneScreenHeader(
            onCloseClick = onCloseClick
        )
        SnackDoneScreenBody(
            snackPhoto = snackPhoto
        )
        ScreenFooter(
            buttonText = "Thank youuu",
            buttonIcon = painterResource(R.drawable.ic_continue),
            onClick = onCloseClick
        )

    }
}