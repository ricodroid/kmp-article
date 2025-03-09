package com.ricodroid.kmp.articleapp.di

import com.ricodroid.kmp.articleapp.articles.di.articlesModule
import com.ricodroid.kmp.articleapp.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule,
)