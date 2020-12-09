package com.example.cleanarchitecture.presentation.di.tvshow

import com.example.cleanarchitecture.presentation.artist.ArtistActivity
import com.example.cleanarchitecture.presentation.movie.MovieActivity
import com.example.cleanarchitecture.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}