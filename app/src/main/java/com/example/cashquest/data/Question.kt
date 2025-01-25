package com.example.cashquest.data


data class Question(
    var id: String = "",
    val question_text: String = "",
    val difficulty: Int = 0,
    val answers: List<Answer> = listOf()
)

data class Answer(
    val answer_text: String = "",
    val correct: Boolean = false
)
