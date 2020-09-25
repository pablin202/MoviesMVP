package com.pdm.moviesmvp.ui

import android.util.Log
import com.pdm.moviesmvp.api.ApiService
import com.pdm.moviesmvp.api.MoviesEntity
import com.pdm.moviesmvp.domain.MovieRepository
import io.reactivex.Observable

class MovieRepositoryImpl(private val api: ApiService) : MovieRepository {

    override fun getMovies(): Observable<MoviesEntity> {
        return api.getTopRatedMovies(1)
            .doOnNext {
                Log.d("getTopRatedMovies", "Dispatching ${it.totalResults} movies data from API...")
            }
    }
}