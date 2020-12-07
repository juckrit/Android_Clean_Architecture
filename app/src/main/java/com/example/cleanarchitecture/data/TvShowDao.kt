package com.example.cleanarchitecture.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query(value = "DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query(value = "SELECT * FROM popular_tvShows")
    suspend fun getTvShows(tvShows: List<TvShow>)
}