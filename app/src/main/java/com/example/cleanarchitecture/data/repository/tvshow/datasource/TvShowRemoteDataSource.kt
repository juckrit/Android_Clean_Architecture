package com.example.cleanarchitecture.data.repository.tvshow.datasource

import com.example.cleanarchitecture.data.model.tvshow.TvShowList

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): TvShowList
}