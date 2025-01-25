package com.example.cashquest.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class CashQuestViewModel: ViewModel() {
    private val db = Firebase.firestore
    val questionsData = mutableStateListOf<Question>()
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
    }
}