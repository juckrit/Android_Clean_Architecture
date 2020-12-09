package com.example.cleanarchitecture.data.repository.artist.datasource

import com.example.cleanarchitecture.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}