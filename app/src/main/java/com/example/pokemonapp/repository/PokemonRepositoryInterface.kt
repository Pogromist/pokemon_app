package com.example.pokemonapp.repository

interface PokemonRepositoryInterface {
    fun getPokemonsList()
    fun savePosition(position: Int)
    fun disposeAll()
}