package com.pdm.moviesmvp.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application: Application) {

    @Provides
    @Singleton
    fun providerContext(): Context = application
}