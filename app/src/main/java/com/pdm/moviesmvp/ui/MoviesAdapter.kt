package com.pdm.moviesmvp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pdm.moviesmvp.R
import com.pdm.moviesmvp.api.MovieEntity
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter constructor(
    private val onMovieSelected: (MovieEntity, View) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieCellViewHolder>() {

    private val movies: MutableList<MovieEntity> = mutableListOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieCellViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(
            R.layout.movie_item,
            p0,
            false
        )
        return MovieCellViewHolder(view)
    }

    override fun onBindViewHolder(view: MovieCellViewHolder, position: Int) {
        val movie = movies[position]
        view.bind(movie, onMovieSelected)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun addMovies(movies: List<MovieEntity>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    inner class MovieCellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity, listener: (MovieEntity, View) -> Unit) = with(itemView) {
            textTitle.text = movie.title
            setOnClickListener { listener(movie, itemView) }
        }
    }
}