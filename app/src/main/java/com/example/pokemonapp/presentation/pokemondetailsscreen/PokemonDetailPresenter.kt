package com.example.pokemonapp.presentation.pokemondetailsscreen

import moxy.MvpPresenter
import javax.inject.Inject

class PokemonDetailPresenter @Inject constructor() : MvpPresenter<PokemonDetailView>() {

    fun onPokemonClicked() {
        // запрос инфы о конкретном покемоне
    }

}