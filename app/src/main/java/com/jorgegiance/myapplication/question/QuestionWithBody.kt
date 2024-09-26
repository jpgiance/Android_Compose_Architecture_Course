package com.jorgegiance.myapplication.question

data class QuestionWithBody(
    val id: String,
    val title: String,
    val body: String,
    val isFavorite: Boolean,
)