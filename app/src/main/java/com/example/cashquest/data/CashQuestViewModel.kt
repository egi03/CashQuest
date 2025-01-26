package com.example.cashquest.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class CashQuestViewModel: ViewModel() {
    private val db = Firebase.firestore
    val questionsData = mutableStateListOf<Question>()
    val leaderboardData = mutableStateListOf<User>()
    init {
        fetchDatabaseData()
    }
    private fun fetchDatabaseData() {
        db.collection("questions")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val question = data.toObject(Question::class.java)
                    if (question != null) {
                        question.id = data.id
                        questionsData.add(question)
                    }
                }
            }
        db.collection("leaderboard")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val user = data.toObject(User::class.java)
                    if (user != null) {
                        user.id = data.id
                        leaderboardData.add(user)
                    }
                }
            }
    }

    var currentAmount by mutableStateOf(0)
        private set

    fun increaseAmount(amount: Int) {
        currentAmount += amount
    }

    fun resetAmount() {
        currentAmount = 0
    }

    var username by mutableStateOf("")

    fun addNewUser(){
        val newUser = User(name = username, amount = currentAmount)

        db.collection("leaderboard")
            .add(newUser)
            .addOnSuccessListener { documentReference ->
                newUser.id = documentReference.id
                leaderboardData.add(newUser)
            }
    }

}