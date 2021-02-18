package com.example.pokemonapp.di.component

import com.example.pokemonapp.di.modules.FragmentModule
import com.example.pokemonapp.presentation.customviewscreen.CustomViewFragment
import com.example.pokemonapp.presentation.pokemondetailsscreen.PokemonDetailFragment
import com.example.pokemonapp.presentation.pokemonlistscreen.PokemonListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        //CiceroneModule::class,
        //NetworkModule::class,
        FragmentModule::class
    ]
)
interface ApplicationComponent {
    fun inject(customViewFragment: CustomViewFragment)
    fun inject(pokemonDetailFragment: PokemonDetailFragment)
    fun inject(pokemonListFragment: PokemonListFragment)
}