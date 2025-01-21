package com.example.cashquest.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cashquest.Routes
import com.example.cashquest.ui.theme.CashQuestTheme

@Composable
fun GameOverScreen(navigation: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "GAME OVER",
            color = MaterialTheme.colorScheme.primaryContainer,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "You won",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 65.sp
            )

            Text(
                text = "10,000€",
                color = Color(0xFF33A063),
                fontWeight = FontWeight.Bold,
                fontSize = 90.sp
            )
        }

        Column {
            GameButton(text = "PLAY AGAIN") { navigation.navigate(Routes.QUESTION_SCREEN) }
            Spacer(modifier = Modifier.height(16.dp))
            GameButton(text = "LEADERBOARD") { navigation.navigate(Routes.LEADERBOARD_SCREEN) }
        }
    }
}

@Composable
fun GameButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.onSurface), // Greyish button
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(200.dp)
            .height(70.dp)
    ) {
        Text(text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
    }
}