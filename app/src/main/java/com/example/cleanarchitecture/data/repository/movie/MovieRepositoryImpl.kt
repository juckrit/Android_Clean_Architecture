package com.example.cleanarchitecture.data.repository.movie

import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanarchitecture.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return  newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieRemoteDataSource.getMovies().movies

        } catch (e: Exception) {

        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (e: Exception) {

        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList

    }

    suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (e: Exception) {

        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList

    }
}