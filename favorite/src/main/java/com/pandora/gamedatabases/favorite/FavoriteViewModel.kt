package com.pandora.gamedatabases.favorite

import  androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pandora.gamedatabases.core.domain.usecase.GameUseCase

class FavoriteViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val favoriteGame = gameUseCase.getFavoriteGame().asLiveData()
}