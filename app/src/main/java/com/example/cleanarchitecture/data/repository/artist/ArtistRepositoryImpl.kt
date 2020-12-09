package com.example.cleanarchitecture.data.repository.artist

import com.example.cleanarchitecture.data.model.artist.Artist
import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cleanarchitecture.domain.repository.ArtistRepository
import com.example.cleanarchitecture.domain.repository.MovieRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {


    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtist = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromApi():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            artistList = response.results
        }catch (e:Exception){

        }
        return artistList

    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (e: Exception) {

        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (e: Exception) {

        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList

    }


}