package com.example.cleanarchitecture.data.repository.movie.datasourceImpl

import com.example.cleanarchitecture.data.api.TMDBService
import com.example.cleanarchitecture.data.model.movie.MovieList
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): MovieList = tmdbService.getPopularMovies(apiKey)

}