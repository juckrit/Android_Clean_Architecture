package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.data.model.artist.Artist
import com.example.cleanarchitecture.domain.repository.ArtistRepository

/**
 * useCase will be Executed from ViewModel
 */
class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()

}