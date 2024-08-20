package com.pandora.gamedatabases.core.utils

import com.pandora.gamedatabases.core.data.source.local.entity.GameEntity
import com.pandora.gamedatabases.core.data.source.remote.response.ResultsItem
import com.pandora.gamedatabases.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItem>): List<GameEntity> {
        val gameList = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                gameId = it.id,
                added = it.added,
                rating = it.rating,
                metacritic = it.metacritic,
                playtime = it.playtime,
                ratingTop = it.ratingTop,
                reviewsTextCount = it.reviewsTextCount,
                saturatedColor = it.saturatedColor,
                ratingsCount = it.ratingsCount,
                slug = it.slug,
                released = it.released,
                suggestionsCount = it.suggestionsCount,
                backgroundImage = it.backgroundImage,
                tba = it.tba,
                dominantColor = it.dominantColor,
                esrbRating = it.esrbRating.toString(),
                name = it.name,
                updated = it.updated,
                clip = it.clip ?: "null",
                reviewsCount = it.reviewsCount,
                isFavorite = false
            )
            gameList.add(game)
        }
        return gameList
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                added = it.added,
                rating = it.rating,
                metacritic = it.metacritic,
                playtime = it.playtime,
                ratingTop = it.ratingTop,
                reviewsTextCount = it.reviewsTextCount,
                saturatedColor = it.saturatedColor,
                ratingsCount = it.ratingsCount,
                slug = it.slug,
                released = it.released,
                suggestionsCount = it.suggestionsCount,
                backgroundImage = it.backgroundImage,
                tba = it.tba,
                dominantColor = it.dominantColor,
                esrbRating = it.esrbRating.toString(),
                name = it.name,
                updated = it.updated,
                clip = it.clip,
                reviewsCount = it.reviewsCount,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        gameId = input.gameId,
        added = input.added,
        rating = input.rating,
        metacritic = input.metacritic,
        playtime = input.playtime,
        ratingTop = input.ratingTop,
        reviewsTextCount = input.reviewsTextCount,
        saturatedColor = input.saturatedColor,
        ratingsCount = input.ratingsCount,
        slug = input.slug,
        released = input.released,
        suggestionsCount = input.suggestionsCount,
        backgroundImage = input.backgroundImage,
        tba = input.tba,
        dominantColor = input.dominantColor,
        esrbRating = input.esrbRating.toString(),
        name = input.name,
        updated = input.updated,
        clip = input.clip,
        reviewsCount = input.reviewsCount,
        isFavorite = input.isFavorite
    )
}