package com.pandora.gamedatabases

import android.app.Application
import com.pandora.gamedatabases.core.di.databaseModule
import com.pandora.gamedatabases.core.di.networkModule
import com.pandora.gamedatabases.core.di.repositoryModule
import com.pandora.gamedatabases.di.useCaseModule
import com.pandora.gamedatabases.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}