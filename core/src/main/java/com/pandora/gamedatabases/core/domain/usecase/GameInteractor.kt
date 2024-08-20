package com.pandora.gamedatabases.core.domain.usecase

import com.pandora.gamedatabases.core.data.Resource
import com.pandora.gamedatabases.core.domain.model.Game
import com.pandora.gamedatabases.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow

class GameInteractor(private val repository: IGameRepository) : GameUseCase {
    override fun getGames(): Flow<Resource<List<Game>>> = repository.getGames()

    override fun getFavoriteGame(): Flow<List<Game>> = repository.getFavoriteGame()

    override fun setFavoriteGame(game: Game, state: Boolean) = repository.setFavoriteGame(game, state)
}