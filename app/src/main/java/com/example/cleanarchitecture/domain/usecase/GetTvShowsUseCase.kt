package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.data.model.tvshow.TvShow
import com.example.cleanarchitecture.domain.repository.TvShowRepository

/**
 * useCase will be Executed from ViewModel
 */
class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()

}