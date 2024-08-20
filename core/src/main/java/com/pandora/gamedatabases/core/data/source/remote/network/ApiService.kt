package com.pandora.gamedatabases.core.data.source.remote.network

import com.pandora.gamedatabases.core.BuildConfig
import com.pandora.gamedatabases.core.data.source.remote.response.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGames(
        @Query("key") key: String = BuildConfig.API_KEY
    ): GamesResponse
}