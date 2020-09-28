package com.pdm.moviesmvp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pdm.moviesmvp.R
import com.pdm.moviesmvp.api.MovieEntity
import com.pdm.moviesmvp.databinding.MovieItemBinding

class MoviesAdapter constructor(
    private val onMovieSelected: (MovieEntity, MovieItemBinding) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieCellViewHolder>() {

    private val movies: MutableList<MovieEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieCellViewHolder {
        val itemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )

        return  MovieCellViewHolder(itemBinding)
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

    inner class MovieCellViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity, listener: (MovieEntity, MovieItemBinding) -> Unit) = with(binding) {
            textTitle.text = movie.title
            root.setOnClickListener { listener(movie, this) }
        }
    }
}