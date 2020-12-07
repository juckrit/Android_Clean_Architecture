package com.example.cleanarchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.model.artist.Artist
import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, Artist::class, TvShow::class], version = 1, exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TvShowDao
}