package com.example.cashquest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cashquest.data.CashQuestViewModel
import com.example.cashquest.ui.GameOverScreen
import com.example.cashquest.ui.QuestionScreen
import com.example.cashquest.ui.theme.MainScreen

object Routes {
    const val START_SCREEN = "startScreen"
    const val LEADERBOARD_SCREEN = "leaderboardScreen"
    const val QUESTION_SCREEN = "questionScreen"
    const val GAME_OVER_SCREEN = "gameOverScreen"
}

@Composable
fun NavigationController(
    viewModel: CashQuestViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.START_SCREEN) {
        composable(Routes.START_SCREEN) {
            MainScreen(viewModel=viewModel, navigation = navController, activeScreen = Routes.START_SCREEN)
        }
        composable(Routes.LEADERBOARD_SCREEN) {
            MainScreen(viewModel=viewModel, navigation = navController, activeScreen = Routes.LEADERBOARD_SCREEN)
        }
        composable(Routes.QUESTION_SCREEN) {
            QuestionScreen(viewModel)
        }
        composable(Routes.GAME_OVER_SCREEN) {
            GameOverScreen(viewModel=viewModel, navigation = navController)
        }
    }
}