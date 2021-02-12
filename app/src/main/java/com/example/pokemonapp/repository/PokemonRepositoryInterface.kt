package com.example.pokemonapp.repository

interface PokemonRepositoryInterface {
    fun getPokemonsList()
    fun getPokemonDetails(position: Int)
}