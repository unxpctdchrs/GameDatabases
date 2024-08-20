package com.pandora.gamedatabases.core.data.source.local

import com.pandora.gamedatabases.core.data.source.local.entity.GameEntity
import com.pandora.gamedatabases.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gameDao: GameDao) {
    fun getAllGames(): Flow<List<GameEntity>> = gameDao.getAllGames()
    fun getFavoriteGame(): Flow<List<GameEntity>> = gameDao.getFavoriteGame()
    suspend fun insertGame(game: List<GameEntity>) = gameDao.insertGame(game)
    fun setFavoriteGame(game: GameEntity, newState: Boolean) {
        game.isFavorite = newState
        gameDao.updateFavoriteGame(game)
    }
}