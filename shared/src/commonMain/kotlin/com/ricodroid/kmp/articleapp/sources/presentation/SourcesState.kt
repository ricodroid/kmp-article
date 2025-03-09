package com.ricodroid.kmp.articleapp.sources.presentation

import com.ricodroid.kmp.articleapp.sources.application.Source

data class SourcesState (
    val sources: List<Source>,
    val loading: Boolean = false,
    val error: String? = null
)
