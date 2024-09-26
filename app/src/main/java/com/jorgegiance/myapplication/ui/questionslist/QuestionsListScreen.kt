package com.jorgegiance.myapplication.ui.questionslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jorgegiance.myapplication.ui.common.composables.QuestionItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsListScreen(
    viewModel: QuestionsListViewModel = hiltViewModel(),
    onQuestionClicked: (String, String) -> Unit,
) {

    val questions = viewModel.lastActiveQuestions.collectAsState()
    val state = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            viewModel.fetchLastActiveQuestions(forceUpdate = true)
            isRefreshing = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchLastActiveQuestions()
    }



//    if (state.isRefreshing) {
//        LaunchedEffect(Unit) {
//            viewModel.fetchLastActiveQuestions(forceUpdate = true)
//            state.endRefresh()
//        }
//    }

    Box {

        PullToRefreshBox(
            modifier = Modifier.align(Alignment.TopCenter),
            state = state,
            isRefreshing = isRefreshing,
            onRefresh = onRefresh,
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 5.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp)
            ) {
                items(questions.value.size) { index ->
                    val question = questions.value[index]
                    QuestionItem(
                        questionId = question.id,
                        questionTitle = question.title,
                        onQuestionClicked = { onQuestionClicked(question.id, question.title) },
                    )
                    if (index < questions.value.size - 1) {
                        HorizontalDivider(
                            modifier = Modifier
                                .padding(top = 20.dp),
                            thickness = 2.dp
                        )
                    }
                }
            }
        }



    }





}