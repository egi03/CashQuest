package com.example.cashquest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cashquest.Routes
import com.example.cashquest.data.CashQuestViewModel

@Composable
fun QuestionScreen(
    viewModel: CashQuestViewModel,
    difficulty: Int,
    navigation: NavController
) {

    if (difficulty == 0) {
        viewModel.resetAmount()
    }

    val questions = viewModel.questionsData.filter { it.difficulty == difficulty }
    val randomQuestion = remember(questions) { questions.random() }

    var selectedAnswerIndex by remember { mutableStateOf<Int?>(null) }
    var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }

    fun handleAnswerSelection(index: Int) {
        val answer = randomQuestion.answers[index]
        selectedAnswerIndex = index
        isAnswerCorrect = answer.correct

        if (answer.correct) {
            viewModel.increaseAmount(100)
            if (difficulty == 10) {
                navigation.navigate(Routes.GAME_OVER_SCREEN)
                viewModel.addNewUser()
            }
            else { navigation.navigate(Routes.questionScreenRoute(difficulty + 1)) }
        } else {
            navigation.navigate(Routes.GAME_OVER_SCREEN)
            if (viewModel.currentAmount > 0) { viewModel.addNewUser() }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Current Amount: $${viewModel.currentAmount}",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Text(
            text = randomQuestion.question_text,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            lineHeight = 40.sp,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                AnswerButton(
                    text = randomQuestion.answers[0].answer_text,
                    isSelected = selectedAnswerIndex == 0,
                    isCorrect = isAnswerCorrect,
                    onClick = { handleAnswerSelection(0) }
                )
                AnswerButton(
                    text = randomQuestion.answers[1].answer_text,
                    isSelected = selectedAnswerIndex == 1,
                    isCorrect = isAnswerCorrect,
                    onClick = { handleAnswerSelection(1) }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                AnswerButton(
                    text = randomQuestion.answers[2].answer_text,
                    isSelected = selectedAnswerIndex == 2,
                    isCorrect = isAnswerCorrect,
                    onClick = { handleAnswerSelection(2) }
                )
                AnswerButton(
                    text = randomQuestion.answers[3].answer_text,
                    isSelected = selectedAnswerIndex == 3,
                    isCorrect = isAnswerCorrect,
                    onClick = { handleAnswerSelection(3) }
                )
            }
        }
    }
}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, isCorrect: Boolean?, onClick: () -> Unit) {
    val backgroundColor = when {
        isSelected && isCorrect == true -> Color(0xFF276B45)
        isSelected && isCorrect == false -> Color(0xFFF44336)
        else -> MaterialTheme.colorScheme.onSurface
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .size(180.dp, 80.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp
        )
    }
}