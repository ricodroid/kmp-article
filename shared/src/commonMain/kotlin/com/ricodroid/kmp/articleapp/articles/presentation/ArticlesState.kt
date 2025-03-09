package com.ricodroid.kmp.articleapp.articles.presentation

import com.ricodroid.kmp.articleapp.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
