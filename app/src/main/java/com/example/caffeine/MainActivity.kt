package com.example.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.caffeine.ui.screens.home_screen.HomeScreen
import com.example.caffeine.ui.screens.home_screen.HomeScreenViewModel
import com.example.caffeine.ui.theme.CaffeineTheme
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideSystemUI()
        setContent {
            CaffeineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val homeViewModel: HomeScreenViewModel = koinViewModel()
                    val uiState by homeViewModel.state.collectAsStateWithLifecycle()
                    HomeScreen(
                        uiState = uiState,
                    )
                }

            }
        }
    }

    private fun hideSystemUI() {
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

        // Hide the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())

        // Optional: Hide status bar too
        // windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())

        // Make it immersive (bars appear temporarily when user swipes)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}