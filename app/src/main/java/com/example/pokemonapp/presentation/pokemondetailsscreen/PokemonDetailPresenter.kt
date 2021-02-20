package com.example.pokemonapp.presentation.pokemondetailsscreen

import com.example.pokemonapp.data.model.PokemonDetailData
import com.example.pokemonapp.repository.PokemonRepositoryDetail
import com.example.pokemonapp.repository.PokemonRepositoryDetailInterface
import com.example.pokemonapp.repository.UtilObject
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PokemonDetailPresenter @Inject constructor() : MvpPresenter<PokemonDetailView>(),
    PokemonRepositoryDetail.OnPokemonDetailsFetched {

    private var pokemonRepositoryDetail: PokemonRepositoryDetailInterface

    init {
        pokemonRepositoryDetail = PokemonRepositoryDetail(this)
        pokemonRepositoryDetail.getPokemonDetails(UtilObject.position!!)
    }

    override fun showPokemonDetails(pokemonDetailData: PokemonDetailData) {
        viewState.showPokemonDetails(pokemonDetailData)
    }
}