package com.example.cleanarchitecture.data.model.artist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_artists")
data class Artist(
    val adult: Boolean,
    val gender: Int,
    @PrimaryKey
    val id: Int,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)