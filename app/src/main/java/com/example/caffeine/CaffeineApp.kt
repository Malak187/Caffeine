package com.example.caffeine

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caffeine.ui.screens.home_screen.HomeScreen
import com.example.caffeine.ui.screens.home_screen.HomeScreenViewModel
import com.example.caffeine.ui.screens.welcome_screen.WelcomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun CaffeineApp(
    navController: NavHostController = rememberNavController()
) {
    val homeViewModel: HomeScreenViewModel = koinViewModel()
    val uiState by homeViewModel.state.collectAsStateWithLifecycle()


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = WelcomeScreen,
        ) {
            composable<WelcomeScreen> {
                WelcomeScreen(
                    onClick = {
                        navController.navigate(HomeScreen) {
                            popUpTo(WelcomeScreen) { inclusive = true }
                        }
                    }
                )
            }

            composable<HomeScreen> {
                HomeScreen(
                    uiState = uiState,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}