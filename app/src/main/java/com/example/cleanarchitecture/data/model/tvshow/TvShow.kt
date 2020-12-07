package com.example.cleanarchitecture.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_tvShows")
data class TvShow(
    val backdrop_path: String,
    val first_air_date: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)