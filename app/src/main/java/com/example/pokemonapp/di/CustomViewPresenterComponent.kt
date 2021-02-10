package com.example.pokemonapp.di

import com.example.pokemonapp.presentation.customviewscreen.CustomViewFragment
import dagger.Component

@Component
interface CustomViewPresenterComponent {
    fun inject(customViewFragment: CustomViewFragment)
}