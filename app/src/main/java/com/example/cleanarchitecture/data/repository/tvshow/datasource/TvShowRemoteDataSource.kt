package com.example.cleanarchitecture.data.repository.tvshow.datasource

import com.example.cleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}