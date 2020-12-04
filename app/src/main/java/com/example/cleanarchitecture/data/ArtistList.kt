package com.example.cleanarchitecture.data

data class ArtistList(
    val page: Int,
    val results: List<Artist>,
    val total_pages: Int,
    val total_results: Int
)