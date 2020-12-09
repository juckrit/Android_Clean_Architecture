package com.example.cleanarchitecture.data.repository.tvshow.datasourceImpl

import com.example.cleanarchitecture.data.api.TMDBService
import com.example.cleanarchitecture.data.model.tvshow.TvShowList
import com.example.cleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String

) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): TvShowList {
       return tmdbService.getPopularTvShows(apiKey)
    }
}