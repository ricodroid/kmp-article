package com.ricodroid.kmp.articleapp.android

import android.app.Application
import com.ricodroid.kmp.articleapp.android.di.databaseModule
import com.ricodroid.kmp.articleapp.android.di.viewModelsModule
import com.ricodroid.kmp.articleapp.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KmpArticleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@KmpArticleApp)
            modules(modules)
        }
    }
}