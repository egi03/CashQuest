package com.example.cashquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cashquest.data.CashQuestViewModel
import com.example.cashquest.ui.theme.CashQuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<CashQuestViewModel>()

        setContent {
            CashQuestTheme {
                NavigationController(viewModel)
            }
        }
    }
}




//@Preview(
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Preview(
//    uiMode = UI_MODE_NIGHT_NO,
//    name = "DefaultPreviewLight"
//)
//@Composable
//fun PreviewQuizScreen() {
//    CashQuestTheme {
//        MainScreen(navigation = NavigationController())
//    }
//}
