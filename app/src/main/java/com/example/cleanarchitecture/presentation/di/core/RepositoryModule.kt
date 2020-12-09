package com.example.cleanarchitecture.presentation.di.core

import com.example.cleanarchitecture.data.repository.artist.ArtistRepositoryImpl
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cleanarchitecture.data.repository.movie.MovieRepositoryImpl
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanarchitecture.data.repository.tvshow.TvShowRepositoryImpl
import com.example.cleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.cleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.cleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.cleanarchitecture.domain.repository.ArtistRepository
import com.example.cleanarchitecture.domain.repository.MovieRepository
import com.example.cleanarchitecture.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}