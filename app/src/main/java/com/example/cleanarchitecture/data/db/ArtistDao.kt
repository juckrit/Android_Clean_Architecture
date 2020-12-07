package com.example.cleanarchitecture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecture.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query(value = "DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query(value = "SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}