package com.example.cashquest.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.cashquest.ui.LeaderboardScreen
import com.example.cashquest.ui.StartScreen
import com.example.cashquest.ui.TopBar

@Composable
fun MainScreen() {
    var activeScreen by remember { mutableStateOf("QUIZ") }

    Column {
        TopBar(activeScreen = activeScreen, onTabSelected = { activeScreen = it })
        when (activeScreen) {
            "QUIZ" -> StartScreen()
            "LEADERBOARD" -> LeaderboardScreen()
        }
    }
}
