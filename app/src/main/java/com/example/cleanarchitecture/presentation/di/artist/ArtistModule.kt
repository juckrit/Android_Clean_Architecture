package com.example.cleanarchitecture.presentation.di.artist

import com.example.cleanarchitecture.domain.usecase.GetArtistsUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.example.cleanarchitecture.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}