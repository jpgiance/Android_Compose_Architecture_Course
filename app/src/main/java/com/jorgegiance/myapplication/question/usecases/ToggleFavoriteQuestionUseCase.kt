package com.jorgegiance.myapplication.question.usecases

import com.jorgegiance.myapplication.common.database.FavoriteQuestionDao
import com.jorgegiance.myapplication.question.FavoriteQuestion
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ToggleFavoriteQuestionUseCase @Inject constructor(
    private val favoriteQuestionDao: FavoriteQuestionDao,
) {

    fun toggleFavoriteQuestion(questionId: String, questionTitle: String) {
        GlobalScope.launch {
            if (favoriteQuestionDao.getById(questionId) != null) {
                favoriteQuestionDao.delete(questionId)
            } else {
                favoriteQuestionDao.upsert(FavoriteQuestion(questionId, questionTitle))
            }
        }
    }
}