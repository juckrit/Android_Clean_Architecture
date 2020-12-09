package com.example.cleanarchitecture.presentation.di.movie

import com.example.cleanarchitecture.presentation.artist.ArtistActivity
import com.example.cleanarchitecture.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}