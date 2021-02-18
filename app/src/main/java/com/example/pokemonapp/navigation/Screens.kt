package com.example.pokemonapp.navigation

import com.example.pokemonapp.presentation.customviewscreen.CustomViewFragment
import com.example.pokemonapp.presentation.pokemondetailsscreen.PokemonDetailFragment
import com.example.pokemonapp.presentation.pokemonlistscreen.PokemonListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun PokemonListScreen() = FragmentScreen { PokemonListFragment() }
    fun PokemonDetailScreen() = FragmentScreen { PokemonDetailFragment() }
    fun CustomViewScreen() = FragmentScreen { CustomViewFragment() }
}