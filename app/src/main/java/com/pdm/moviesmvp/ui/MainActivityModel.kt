package com.pdm.moviesmvp.ui

import android.util.Log
import com.pdm.moviesmvp.api.MoviesEntity
import com.pdm.moviesmvp.domain.MovieRepository
import io.reactivex.Observable

class MainActivityModel(private val repository: MovieRepository) : MainActivityMVP.Model {
    override fun getMovies(): Observable<MoviesEntity> {
        return repository.getMovies()
            // 1
            .map {
                it
            }
            // 2
            .onErrorReturn {
                Log.d("getMovies", "An error occurred")
                MoviesEntity(0, listOf(), 0, 0)
            }
    }
}