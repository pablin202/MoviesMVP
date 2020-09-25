package com.pdm.moviesmvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdm.moviesmvp.R
import com.pdm.moviesmvp.api.MovieEntity
import com.pdm.moviesmvp.ui.common.app
import com.pdm.moviesmvp.ui.common.snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityMVP.View {

    private val TAG = MainActivity::class.java.name

    @Inject
    lateinit var presenter: MainActivityMVP.Presenter

    private val layoutManagerMovies = LinearLayoutManager(
        this,
        LinearLayoutManager.VERTICAL,
        false
    )

    private val moviesAdapter by lazy {
        MoviesAdapter() { _, _ ->
            // navigateToMovieDetailsActivity(movie, view)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app.component.inject(this)
        recyclerView.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = moviesAdapter
            hasFixedSize()
            layoutManager = layoutManagerMovies
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.loadData()
    }

    override fun onStop() {
        super.onStop()
        presenter.rxJavaUnsubscribe()
        moviesAdapter.addMovies(listOf())
        moviesAdapter.notifyDataSetChanged()
    }

    override fun showProgressBar(value: Boolean) {
        progressBar.visibility = if (value) View.VISIBLE else View.GONE
    }

    override fun updateData(movies: List<MovieEntity>) {
        moviesAdapter.addMovies(movies)
    }

    override fun showSnackBar(message: String) {
        root.snackbar(message)
    }
}