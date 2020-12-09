package com.example.cleanarchitecture.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.domain.usecase.GetArtistsUseCase
import com.example.cleanarchitecture.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateMoviesUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase

) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}