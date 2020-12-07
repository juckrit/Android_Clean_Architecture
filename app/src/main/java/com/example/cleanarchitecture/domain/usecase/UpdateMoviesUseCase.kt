package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.domain.repository.MovieRepository

/**
 * useCase will be Executed from ViewModel
 */
class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}