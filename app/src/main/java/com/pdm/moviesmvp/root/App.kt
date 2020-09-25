package com.pdm.moviesmvp.root

import android.app.Application
import com.pdm.moviesmvp.ui.MainActivityModule

class App: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this))
            .mainActivityModule(MainActivityModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}