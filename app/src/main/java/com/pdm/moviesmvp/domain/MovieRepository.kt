package com.pdm.moviesmvp.domain

import com.pdm.moviesmvp.api.MoviesEntity
import io.reactivex.Observable

interface MovieRepository {
    fun getMovies(): Observable<MoviesEntity>
}