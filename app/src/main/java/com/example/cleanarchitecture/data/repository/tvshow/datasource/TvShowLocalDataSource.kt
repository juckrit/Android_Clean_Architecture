package com.example.cleanarchitecture.data.repository.tvshow.datasource

import com.example.cleanarchitecture.data.model.tvshow.TvShow

interface  TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}