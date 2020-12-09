package com.example.cleanarchitecture.presentation.di.core

import com.example.cleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecture.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class]
)

interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
}