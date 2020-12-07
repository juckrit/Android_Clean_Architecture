package com.example.cleanarchitecture.data.repository.movie.datasource

import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()

}