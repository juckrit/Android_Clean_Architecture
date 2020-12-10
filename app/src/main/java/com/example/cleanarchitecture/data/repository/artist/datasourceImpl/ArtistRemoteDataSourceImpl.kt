package com.example.cleanarchitecture.data.repository.artist.datasourceImpl

import com.example.cleanarchitecture.data.api.TMDBService
import com.example.cleanarchitecture.data.model.artist.ArtistList
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}