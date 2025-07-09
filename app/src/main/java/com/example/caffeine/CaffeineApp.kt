package com.example.caffeine

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.caffeine.ui.screens.coffee_order.CoffeeOrderScreen
import com.example.caffeine.ui.screens.coffee_order.CoffeeOrderViewModel
import com.example.caffeine.ui.screens.done_coffee.CoffeeDoneScreen
import com.example.caffeine.ui.screens.done_coffee.CoffeeDoneViewModel
import com.example.caffeine.ui.screens.loading_order.FinishingOrderScreen
import com.example.caffeine.ui.screens.loading_order.FinishingOrderViewModel
import com.example.caffeine.ui.screens.home.HomeScreen
import com.example.caffeine.ui.screens.home.HomeScreenViewModel
import com.example.caffeine.ui.screens.pick_snack.SnackPickerScreen
import com.example.caffeine.ui.screens.pick_snack.Snacks
import com.example.caffeine.ui.screens.welcome.WelcomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun CaffeineApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = WelcomeNavScreen,
        ) {
            composable<WelcomeNavScreen> {
                WelcomeScreen(
                    onClick = {
                        navController.navigate(HomeNavScreen) {
                            popUpTo(WelcomeNavScreen) { inclusive = true }
                        }
                    }
                )
            }

            composable<HomeNavScreen> {
                val homeViewModel: HomeScreenViewModel = koinViewModel()
                val uiState by homeViewModel.state.collectAsStateWithLifecycle()
                HomeScreen(
                    uiState = uiState,
                    onClick = {
                        val selectedCup = uiState.coffeeCups[uiState.selectedCupIndex]
                        navController.navigate(
                            CoffeeOrderNavScreen(
                                title = selectedCup.title,
                                photo = selectedCup.photo
                            )
                        )
                    },
                    listener = homeViewModel,
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable<CoffeeOrderNavScreen> {
                val args = it.toRoute<CoffeeOrderNavScreen>()
                val coffeeOrderViewModel: CoffeeOrderViewModel = koinViewModel()
                val uiState by coffeeOrderViewModel.state.collectAsStateWithLifecycle()

                LaunchedEffect(Unit) {
                    coffeeOrderViewModel.loadCoffeeCup(
                        title = args.title,
                        photo = args.photo
                    )
                }
                CoffeeOrderScreen(
                    uiState = uiState,
                    listener = coffeeOrderViewModel,
                    onButtonClick = {
                        navController.navigate(
                            FinishingOrderNavScreen(
                                photo = uiState.coffeeType.photo,
                                size = uiState.coffeeType.size,
                                litres = uiState.coffeeType.litres
                            )
                        )
                    },
                    onGoBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable<FinishingOrderNavScreen> {
                val args = it.toRoute<FinishingOrderNavScreen>()
                val finishingOrderViewModel: FinishingOrderViewModel = koinViewModel()
                val uiState by finishingOrderViewModel.state.collectAsStateWithLifecycle()
                LaunchedEffect(Unit) {
                    finishingOrderViewModel.loadCoffeeOrder(
                        photo = args.photo,
                        size = args.size,
                        litres = args.litres
                    )
                }

                FinishingOrderScreen(
                    uiState = uiState,
                    onAnimationComplete = {
                        navController.navigate(CoffeeDoneNavScreen(uiState.coffeeType.photo))
                    }
                )
            }

            composable<CoffeeDoneNavScreen> {
                val args = it.toRoute<CoffeeDoneNavScreen>()
                val coffeeDoneViewModel: CoffeeDoneViewModel = koinViewModel()
                val coffeePhoto by coffeeDoneViewModel.coffeePhoto.collectAsStateWithLifecycle()
                LaunchedEffect(Unit) {
                    coffeeDoneViewModel.loadCoffeePhoto(args.photo)
                }
                CoffeeDoneScreen(
                    coffeePhoto = coffeePhoto,
                    modifier = Modifier.fillMaxSize(),
                    onButtonClick = {
                        navController.navigate(SnackPickerNavScreen)
                    },
                    onClosesClick = {
                        navController.navigate(WelcomeNavScreen) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }

            composable<SnackPickerNavScreen>{
                SnackPickerScreen(
                    snacks = Snacks.snacksOptions,
                    onClosesClick = {
                        navController.navigate(WelcomeNavScreen) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}