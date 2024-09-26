package com.jorgegiance.myapplication.ui.favoritequestions

import androidx.lifecycle.ViewModel
import com.jorgegiance.myapplication.question.usecases.ObserveFavoriteQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteQuestionsViewModel @Inject constructor(
    private val observeFavoriteQuestionsUseCase: ObserveFavoriteQuestionsUseCase,
): ViewModel() {

    val favoriteQuestions = observeFavoriteQuestionsUseCase.observeFavorites()
}