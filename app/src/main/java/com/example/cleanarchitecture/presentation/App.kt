package com.example.cleanarchitecture.presentation

import android.app.Application
import com.example.cleanarchitecture.BuildConfig
import com.example.cleanarchitecture.presentation.di.Injector
import com.example.cleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecture.presentation.di.core.*
import com.example.cleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecture.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                //เพิ่มแค่  module ที่มี contructor parameter
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()


    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}