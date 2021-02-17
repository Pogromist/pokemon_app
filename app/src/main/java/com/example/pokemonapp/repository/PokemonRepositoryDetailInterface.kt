package com.example.pokemonapp.repository

interface PokemonRepositoryDetailInterface {
    fun getPokemonDetails(position: Int)
    fun dispose()
}