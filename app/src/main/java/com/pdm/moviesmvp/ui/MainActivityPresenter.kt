package com.pdm.moviesmvp.ui

import com.pdm.moviesmvp.api.MovieEntity
import com.pdm.moviesmvp.api.MoviesEntity
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter(var model: MainActivityMVP.Model) : MainActivityMVP.Presenter {

    private var view: MainActivityMVP.View? = null
    private var subscription: Disposable? = null

    override fun setView(view: MainActivityMVP.View) {
        this.view = view
    }

    override fun loadData() {
        view?.showProgressBar(true)
        subscription = model.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(myObserver)
    }

    override fun rxJavaUnsubscribe() {
        subscription?.dispose()
    }

    private var myObserver: DisposableObserver<MoviesEntity> =
        object : DisposableObserver<MoviesEntity>() {

            override fun onError(e: Throwable) {
                view?.showSnackBar(e.message.toString())
            }

            override fun onComplete() {
                //Has access to Disposable
            }

            override fun onNext(t: MoviesEntity) {
                view?.updateData(t.results)
                view?.showProgressBar(false)
            }
        }
}