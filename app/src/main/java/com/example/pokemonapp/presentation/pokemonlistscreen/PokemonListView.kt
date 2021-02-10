package com.example.pokemonapp.presentation.pokemonlistscreen

import com.example.pokemonapp.data.model.PokemonResponseData
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface PokemonListView : MvpView {

    fun showPokemonsList(pokemonResponseData: PokemonResponseData)
    fun showSuccessMessage()
    fun showErrorMessage()

}