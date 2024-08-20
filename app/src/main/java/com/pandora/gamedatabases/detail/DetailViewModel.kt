package com.pandora.gamedatabases.detail

import androidx.lifecycle.ViewModel
import com.pandora.gamedatabases.core.domain.model.Game
import com.pandora.gamedatabases.core.domain.usecase.GameUseCase

class DetailViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGame(game: Game, newState: Boolean) = gameUseCase.setFavoriteGame(game, newState)
}