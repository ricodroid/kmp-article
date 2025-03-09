package com.ricodroid.kmp.articleapp.sources.presentation

import com.ricodroid.kmp.articleapp.BaseViewModel
import com.ricodroid.kmp.articleapp.sources.application.SourcesUseCase
import com.ricodroid.kmp.articleapp.sources.presentation.SourcesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(private val useCase: SourcesUseCase) : BaseViewModel() {

    private val _sourcesState =
        MutableStateFlow(SourcesState(listOf(), true, null))
    val sourcesState: StateFlow<SourcesState> get() = _sourcesState

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            _sourcesState.emit(SourcesState(_sourcesState.value.sources, true, null))

            val sources = useCase.getSources()

            _sourcesState.emit(
                SourcesState(sources)
            )
        }
    }
}