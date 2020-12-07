package com.example.cleanarchitecture.data.api

import com.example.cleanarchitecture.data.ArtistList
import com.example.cleanarchitecture.data.MovieList
import com.example.cleanarchitecture.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey:String):Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")apiKey:String):Response<ArtistList>

}