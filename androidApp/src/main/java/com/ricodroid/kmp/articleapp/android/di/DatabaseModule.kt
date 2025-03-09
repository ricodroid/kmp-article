package com.ricodroid.kmp.articleapp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.ricodroid.kmp.articleapp.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ricodroid.kmp.dailypulse.db.DailyPulseDatabase

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}