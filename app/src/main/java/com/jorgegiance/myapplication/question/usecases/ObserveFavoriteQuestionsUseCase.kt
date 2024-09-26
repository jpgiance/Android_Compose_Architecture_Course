package com.jorgegiance.myapplication.question.usecases

import com.jorgegiance.myapplication.common.database.FavoriteQuestionDao
import com.jorgegiance.myapplication.question.FavoriteQuestion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveFavoriteQuestionsUseCase @Inject constructor(
    private val favoriteQuestionDao: FavoriteQuestionDao,
) {

    fun observeFavorites(): Flow<List<FavoriteQuestion>> {
        return favoriteQuestionDao.observe()
    }
}