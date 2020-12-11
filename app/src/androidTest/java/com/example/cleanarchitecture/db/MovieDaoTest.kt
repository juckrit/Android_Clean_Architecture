package com.anushka.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cleanarchitecture.data.db.MovieDao
import com.example.cleanarchitecture.data.db.TMDBDatabase
import com.example.cleanarchitecture.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var movieDao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        movieDao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMovieTest() = runBlocking {
        val movies = listOf(
            Movie(1,"overview1","path1","date1","title1"),
            Movie(2,"overview2","path2","date2","title2"),
            Movie(3,"overview3","path3","date3","title3")
        )
        movieDao.saveMovies(movies)
        val allMovies = movieDao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMovieTest() = runBlocking {
        val movies = listOf(
            Movie(1,"overview1","path1","date1","title1"),
            Movie(2,"overview2","path2","date2","title2"),
            Movie(3,"overview3","path3","date3","title3")
        )
        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()
        val allMovies = movieDao.getMovies()
        Truth.assertThat(allMovies).isEmpty()
    }
}