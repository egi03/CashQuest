package com.example.cashquest.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.cashquest.Routes
import com.example.cashquest.data.CashQuestViewModel
import com.example.cashquest.ui.LeaderboardScreen
import com.example.cashquest.ui.StartScreen
import com.example.cashquest.ui.TopBar

@Composable
fun MainScreen(viewModel: CashQuestViewModel,navigation: NavController, activeScreen: String) {

    Column {
        TopBar(activeScreen = activeScreen, navigation = navigation)
        when (activeScreen) {
            Routes.START_SCREEN -> StartScreen(navigation = navigation, viewModel = viewModel)
            Routes.LEADERBOARD_SCREEN -> LeaderboardScreen(viewModel)
        }
    }
}
