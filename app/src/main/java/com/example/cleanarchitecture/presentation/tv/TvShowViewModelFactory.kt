package com.example.cleanarchitecture.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase

) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}