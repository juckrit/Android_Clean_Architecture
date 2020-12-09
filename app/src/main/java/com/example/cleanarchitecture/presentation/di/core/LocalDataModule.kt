package com.example.cleanarchitecture.presentation.di.core

import com.example.cleanarchitecture.data.db.ArtistDao
import com.example.cleanarchitecture.data.db.MovieDao
import com.example.cleanarchitecture.data.db.TvShowDao
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanarchitecture.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.cleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanarchitecture.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.cleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}