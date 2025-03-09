package com.ricodroid.kmp.articleapp.sources.di

import org.koin.dsl.module
import com.ricodroid.kmp.articleapp.sources.data.SourcesDataSource
import com.ricodroid.kmp.articleapp.sources.data.SourcesRepository
import com.ricodroid.kmp.articleapp.sources.data.SourcesService
import com.ricodroid.kmp.articleapp.sources.application.SourcesUseCase
import com.ricodroid.kmp.articleapp.sources.presentation.SourcesViewModel

val sourcesModule = module {

    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}
