package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.data.model.movie.Movie

/**
 * repo will be implemented in data layer
 */
interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}