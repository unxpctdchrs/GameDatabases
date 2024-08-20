package com.pandora.gamedatabases.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val gameId: Int,
    val added: Int,
    val rating: Double,
    val metacritic: Int,
    val playtime: Int,
    val ratingTop: Int,
    val reviewsTextCount: Int,
    val saturatedColor: String,
    val ratingsCount: Int,
    val slug: String,
    val released: String,
    val suggestionsCount: Int,
    val backgroundImage: String,
    val tba: Boolean,
    val dominantColor: String,
    val esrbRating: String,
    val name: String,
    val updated: String,
    val clip: String,
    val reviewsCount: Int,
    val isFavorite: Boolean
) : Parcelable