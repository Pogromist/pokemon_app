package com.example.pokemonapp.network

import com.example.pokemonapp.data.model.PokemonDetailData
import com.example.pokemonapp.data.model.PokemonNameData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon")
    fun getPokemonList(): Observable<PokemonNameData>

    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Int?): Observable<PokemonDetailData>
}