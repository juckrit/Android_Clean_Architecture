package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.data.model.artist.Artist

/**
 * repo will be implemented in data layer
 */

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}