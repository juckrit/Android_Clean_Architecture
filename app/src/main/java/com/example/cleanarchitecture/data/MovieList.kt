package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.data.Movie

data class MovieList(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)