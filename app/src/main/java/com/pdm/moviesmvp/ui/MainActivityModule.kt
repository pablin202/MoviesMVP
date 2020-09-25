package com.pdm.moviesmvp.ui

import com.pdm.moviesmvp.api.ApiService
import com.pdm.moviesmvp.domain.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    fun provideLoginActivityPresenter(model: MainActivityMVP.Model): MainActivityMVP.Presenter {
        return MainActivityPresenter(model)
    }

    @Provides
    fun provideLoginActivityModel(repository: MovieRepository): MainActivityMVP.Model {
        return MainActivityModel(repository)
    }

    @Provides
    fun provideLoginRepository(api: ApiService): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}