package com.ricodroid.kmp.articleapp.android.di

import com.ricodroid.kmp.articleapp.articles.presentation.ArticlesViewModel
import com.ricodroid.kmp.articleapp.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}