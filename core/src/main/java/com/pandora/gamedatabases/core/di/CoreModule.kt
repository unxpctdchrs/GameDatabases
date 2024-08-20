package com.pandora.gamedatabases.core.di

import androidx.room.Room
import com.pandora.gamedatabases.core.data.GameRepository
import com.pandora.gamedatabases.core.data.source.local.LocalDataSource
import com.pandora.gamedatabases.core.data.source.local.room.GameDatabase
import com.pandora.gamedatabases.core.data.source.remote.RemoteDataSource
import com.pandora.gamedatabases.core.data.source.remote.network.ApiService
import com.pandora.gamedatabases.core.domain.repository.IGameRepository
import com.pandora.gamedatabases.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val databaseModule = module {
    factory { get<GameDatabase>().gameDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            GameDatabase::class.java, "Game.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IGameRepository> { GameRepository(get(), get(), get()) }
}