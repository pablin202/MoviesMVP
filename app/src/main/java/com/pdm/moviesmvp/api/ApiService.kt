package com.pdm.moviesmvp.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("page") page: Int): Observable<MoviesEntity>
}