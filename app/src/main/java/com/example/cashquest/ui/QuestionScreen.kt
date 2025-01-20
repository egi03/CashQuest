package com.example.cashquest.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import com.example.cashquest.ui.theme.CashQuestTheme

@Composable
fun QuizScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Current Amount: $0",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Text(
            text = "Question texttexttexttexttexttexttexttexttexttexttexttext?",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium,
            lineHeight = 50.sp,
            fontSize = 40.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
            )

        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                AnswerButton(text = "Answer A")
                AnswerButton(text = "Answer B")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                AnswerButton(text = "Answer C")
                AnswerButton(text = "Answer D")
            }
        }
    }
}

@Composable
fun AnswerButton(text: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .size(150.dp, 70.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
fun PreviewWuizScreen(){
    CashQuestTheme {
        QuizScreen()
    }
}