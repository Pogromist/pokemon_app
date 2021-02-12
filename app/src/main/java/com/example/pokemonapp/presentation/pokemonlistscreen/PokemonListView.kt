package com.example.pokemonapp.presentation.pokemonlistscreen

import com.example.pokemonapp.data.model.PokemonNameData
import com.example.pokemonapp.data.model.Result
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface PokemonListView : MvpView {

    fun showPokemonsList(pokemonResponseData: List<Result>)
    fun showSuccessMessage()
    fun showErrorMessage()

}