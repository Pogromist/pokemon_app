package com.example.pokemonapp

import android.app.Application
import com.example.pokemonapp.di.component.ApplicationComponent
import com.example.pokemonapp.di.component.DaggerApplicationComponent
import com.example.pokemonapp.di.modules.FragmentModule
import com.github.terrakok.cicerone.Cicerone

class App : Application() {

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        setup()
    }

    private fun setup() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }

}