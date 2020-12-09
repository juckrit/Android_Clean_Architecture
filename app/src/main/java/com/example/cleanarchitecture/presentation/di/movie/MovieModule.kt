package com.example.cleanarchitecture.presentation.di.movie

import com.example.cleanarchitecture.domain.usecase.GetArtistsUseCase
import com.example.cleanarchitecture.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.example.cleanarchitecture.presentation.artist.ArtistViewModelFactory
import com.example.cleanarchitecture.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}