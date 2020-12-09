package com.example.cleanarchitecture.presentation.di.tvshow

import com.example.cleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import com.example.cleanarchitecture.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}