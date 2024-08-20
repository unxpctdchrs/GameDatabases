package com.pandora.gamedatabases.core.data

import com.pandora.gamedatabases.core.data.source.local.LocalDataSource
import com.pandora.gamedatabases.core.data.source.remote.RemoteDataSource
import com.pandora.gamedatabases.core.data.source.remote.network.ApiResponse
import com.pandora.gamedatabases.core.data.source.remote.response.ResultsItem
import com.pandora.gamedatabases.core.domain.model.Game
import com.pandora.gamedatabases.core.domain.repository.IGameRepository
import com.pandora.gamedatabases.core.utils.AppExecutors
import com.pandora.gamedatabases.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRepository {
    override fun getGames(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<ResultsItem>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGames().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Game>?): Boolean = data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultsItem>>> = remoteDataSource.getGames()

            override suspend fun saveCallResult(data: List<ResultsItem>) {
                val gameList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(gameList)
            }
        }.asFlow()

    override fun getFavoriteGame(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteGame(game: Game, state: Boolean) {
        val gameEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(gameEntity, state) }
    }
}