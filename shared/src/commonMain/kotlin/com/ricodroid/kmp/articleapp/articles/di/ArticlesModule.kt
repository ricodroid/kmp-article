package com.ricodroid.kmp.articleapp.articles.di

import com.ricodroid.kmp.articleapp.articles.data.ArticlesDataSource
import com.ricodroid.kmp.articleapp.articles.data.ArticlesRepository
import com.ricodroid.kmp.articleapp.articles.data.ArticlesService
import com.ricodroid.kmp.articleapp.articles.application.ArticlesUseCase
import com.ricodroid.kmp.articleapp.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}