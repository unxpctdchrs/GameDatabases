package com.pandora.gamedatabases.core.domain.repository

import com.pandora.gamedatabases.core.data.Resource
import com.pandora.gamedatabases.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
    fun getGames(): Flow<Resource<List<Game>>>

    fun getFavoriteGame(): Flow<List<Game>>

    fun setFavoriteGame(game: Game, state: Boolean)
}