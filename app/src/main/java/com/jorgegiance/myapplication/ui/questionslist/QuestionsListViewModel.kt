package com.jorgegiance.myapplication.ui.questionslist

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jorgegiance.myapplication.question.Question
import com.jorgegiance.myapplication.question.usecases.FetchQuestionsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuestionsListViewModel @Inject constructor(
    private val fetchQuestionsListUseCase: FetchQuestionsListUseCase
): ViewModel() {

    val lastActiveQuestions = MutableStateFlow<List<Question>>(emptyList())

    suspend fun fetchLastActiveQuestions(forceUpdate: Boolean = false) {
        withContext(Dispatchers.Main.immediate) {
            if (forceUpdate || lastActiveQuestions.value.isEmpty()) {
                lastActiveQuestions.value = fetchQuestionsListUseCase.fetchLastActiveQuestions()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("QuestionsListViewModel", "onCleared()")
    }

}