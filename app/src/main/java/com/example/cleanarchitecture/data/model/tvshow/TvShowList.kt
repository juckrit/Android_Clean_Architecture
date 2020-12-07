package com.example.cleanarchitecture.data.model.tvshow

data class TvShowList(
    val page: Int,
    val results: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)