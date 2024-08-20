package com.pandora.gamedatabases.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pandora.gamedatabases.core.domain.usecase.GameUseCase

class HomeViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val game = gameUseCase.getGames().asLiveData()
}