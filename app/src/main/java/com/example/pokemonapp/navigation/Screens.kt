package com.example.pokemonapp.navigation

import com.example.pokemonapp.presentation.customviewscreen.CustomViewFragment
import com.example.pokemonapp.presentation.pokemondetailsscreen.PokemonDetailFragment
import com.example.pokemonapp.presentation.pokemonlistscreen.PokemonListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun pokemonListScreen() = FragmentScreen { PokemonListFragment() }
    fun pokemonDetailScreen() = FragmentScreen { PokemonDetailFragment() }
    fun customViewScreen() = FragmentScreen { CustomViewFragment() }
}