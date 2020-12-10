package com.example.cleanarchitecture.data.repository.movie.datasource

import com.example.cleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}