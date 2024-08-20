package com.pandora.gamedatabases.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "games")
data class GameEntity (

    @PrimaryKey
    @ColumnInfo(name = "gameId")
    var gameId: Int,

    @ColumnInfo(name = "added")
    var added: Int,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "metacritic")
    var metacritic: Int,

    @ColumnInfo(name = "playtime")
    var playtime: Int,

    @ColumnInfo(name = "rating_top")
    var ratingTop: Int,

    @ColumnInfo(name = "reviews_text_count")
    var reviewsTextCount: Int,

    @ColumnInfo(name = "saturated_color")
    var saturatedColor: String,

    @ColumnInfo(name = "ratings_count")
    var ratingsCount: Int,

    @ColumnInfo(name = "slug")
    var slug: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "suggestions_count")
    var suggestionsCount: Int,

    @ColumnInfo(name = "background_image")
    var backgroundImage: String,

    @ColumnInfo(name = "tba")
    var tba: Boolean,

    @ColumnInfo(name = "dominant_color")
    var dominantColor: String,

    @ColumnInfo(name = "esrb_rating")
    var esrbRating: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "updated")
    var updated: String,

    @ColumnInfo(name = "clip")
    var clip: String,

    @ColumnInfo(name = "reviews_count")
    var reviewsCount: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable