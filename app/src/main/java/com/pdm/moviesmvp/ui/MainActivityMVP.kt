package com.pdm.moviesmvp.ui

import com.pdm.moviesmvp.api.MovieEntity
import com.pdm.moviesmvp.api.MoviesEntity
import io.reactivex.Observable

interface MainActivityMVP {
    interface View {
        fun showProgressBar(value: Boolean)
        fun updateData(movies: List<MovieEntity>)
        fun showSnackBar(message: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun loadData()
        fun rxJavaUnsubscribe()
    }

    interface Model {
        fun getMovies() : Observable<MoviesEntity>
    }
}