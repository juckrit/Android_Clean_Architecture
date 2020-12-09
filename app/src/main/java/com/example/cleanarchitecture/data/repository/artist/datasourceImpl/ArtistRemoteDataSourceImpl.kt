package com.example.cleanarchitecture.data.repository.artist.datasourceImpl

import com.example.cleanarchitecture.data.api.TMDBService
import com.example.cleanarchitecture.data.model.artist.ArtistList
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): ArtistList {
        return tmdbService.getPopularArtists(apiKey)
    }
}