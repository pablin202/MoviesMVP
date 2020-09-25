package com.pdm.moviesmvp.api

import com.google.gson.annotations.SerializedName

data class MoviesEntity(
    val page: Int,
    val results: List<MovieEntity>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)