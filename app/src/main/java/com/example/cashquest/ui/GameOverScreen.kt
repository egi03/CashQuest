package com.example.cashquest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cashquest.Routes
import com.example.cashquest.data.CashQuestViewModel

@Composable
fun GameOverScreen(
    viewModel: CashQuestViewModel,
    navigation: NavController) {

    val questionsAnswered = viewModel.currentAmount / 100

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Rezultat: ${questionsAnswered}/10",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                lineHeight = 50.sp
            )
            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "Osvojili ste",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 65.sp
            )

            Text(
                text = viewModel.currentAmount.toString() + " €",
                color = Color(0xFF33A063),
                fontWeight = FontWeight.Bold,
                fontSize = 90.sp
            )
        }

        Column {
            GameButton(text = "IGRAJ PONOVO") { navigation.navigate(Routes.questionScreenRoute(0)) }
            Spacer(modifier = Modifier.height(16.dp))
            GameButton(text = "RANG LISTA") { navigation.navigate(Routes.LEADERBOARD_SCREEN) }
        }
    }
}

@Composable
fun GameButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.onSurface),
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