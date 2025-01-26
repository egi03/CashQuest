package com.example.cashquest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cashquest.R
import com.example.cashquest.Routes
import com.example.cashquest.data.CashQuestViewModel

@Composable
fun StartScreen(navigation: NavController, viewModel: CashQuestViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.ic_cash_quest),
                contentDescription = "Cash Quest icon",
                Modifier.width(200.dp)
            )
            Text(
                text = "CASH QUEST",
                fontSize = 50.sp,
                lineHeight = 50.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(32.dp))

            TextField(
                value = viewModel.username,
                onValueChange = { viewModel.username = it },
                singleLine = true,
                label = { Text(text = "Vaše ime") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (viewModel.username.isNotBlank()){
                            navigation.navigate(Routes.questionScreenRoute(0))
                        }
                    }
                )
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    if (viewModel.username.isNotBlank()){
                        navigation.navigate(Routes.questionScreenRoute(0))
                    }
                          },
                modifier = Modifier
                    .height(56.dp)
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(text = "Pokreni kviz", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}
