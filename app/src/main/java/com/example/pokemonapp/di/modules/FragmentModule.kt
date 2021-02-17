package com.example.pokemonapp.di.modules

import com.example.pokemonapp.presentation.customviewscreen.CustomViewPresenter
import com.example.pokemonapp.presentation.pokemondetailsscreen.PokemonDetailPresenter
import com.example.pokemonapp.presentation.pokemonlistscreen.PokemonListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun providePokemonListPresenter() : PokemonListPresenter {
        return PokemonListPresenter()
    }

    @Provides
    fun providePokemonDetailPresenter() : PokemonDetailPresenter {
        return PokemonDetailPresenter()
    }

    @Provides
    fun provideCustomViewPresenter() : CustomViewPresenter {
        return CustomViewPresenter()
    }
}