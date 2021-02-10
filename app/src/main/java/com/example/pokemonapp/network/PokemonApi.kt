package com.example.pokemonapp.network

import com.example.pokemonapp.data.model.PokemonResponseData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon")
    fun getPokemonList(): Observable<PokemonResponseData>

}