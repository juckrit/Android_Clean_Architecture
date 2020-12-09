package com.example.cleanarchitecture.data.repository.artist.datasource

import com.example.cleanarchitecture.data.model.artist.ArtistList

interface ArtistRemoteDataSource {
    suspend fun getArtists():ArtistList
}