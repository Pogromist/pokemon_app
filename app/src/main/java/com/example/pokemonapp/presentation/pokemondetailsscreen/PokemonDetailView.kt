package com.example.pokemonapp.presentation.pokemondetailsscreen

import com.example.pokemonapp.data.model.PokemonDetailData
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface PokemonDetailView : MvpView {
    fun showPokemonDetails(pokemonDetailData: PokemonDetailData)
}