package com.example.caffeine.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.caffeine.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_semibold)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.25.sp

    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold),
            ),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.25.sp
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.sniglet)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 50.sp,
        letterSpacing = 0.25.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.25.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_medium)
        ),
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.25.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.25.sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.25.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_medium)
        ),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.25.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.25.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.urbanist_bold)
        ),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.25.sp
    ),




    )