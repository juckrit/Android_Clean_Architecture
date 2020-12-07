package com.example.cleanarchitecture.data.model.artist

data class ArtistList(
    val page: Int,
    val results: List<Artist>,
    val total_pages: Int,
    val total_results: Int
)