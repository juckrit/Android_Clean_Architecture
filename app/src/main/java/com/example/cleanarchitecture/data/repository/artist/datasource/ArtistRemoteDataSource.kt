package com.example.cleanarchitecture.data.repository.artist.datasource

import com.example.cleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}