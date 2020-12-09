package com.example.cleanarchitecture.presentation.di

import com.example.cleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecture.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
}