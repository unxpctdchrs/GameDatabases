package com.pandora.gamedatabases.di

import com.pandora.gamedatabases.core.domain.usecase.GameInteractor
import com.pandora.gamedatabases.core.domain.usecase.GameUseCase
import com.pandora.gamedatabases.detail.DetailViewModel
import com.pandora.gamedatabases.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}