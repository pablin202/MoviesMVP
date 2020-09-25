package com.pdm.moviesmvp.root

import com.pdm.moviesmvp.api.NetworkModule
import com.pdm.moviesmvp.ui.MainActivity
import com.pdm.moviesmvp.ui.MainActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, MainActivityModule::class])
interface ApplicationComponent {
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}