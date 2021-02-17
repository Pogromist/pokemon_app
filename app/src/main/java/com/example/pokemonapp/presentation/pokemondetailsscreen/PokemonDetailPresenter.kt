package com.example.pokemonapp.presentation.pokemondetailsscreen

import android.util.Log
import com.example.pokemonapp.data.model.PokemonDetailData
import com.example.pokemonapp.presentation.pokemonlistscreen.PokemonListFragment
import com.example.pokemonapp.repository.PokemonRepositoryDetail
import com.example.pokemonapp.repository.PokemonRepositoryDetailInterface
import com.example.pokemonapp.repository.Position
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PokemonDetailPresenter @Inject constructor() : MvpPresenter<PokemonDetailView>(),
    PokemonRepositoryDetail.OnPokemonDetailsFetched {

    private var pokemonRepositoryDetail: PokemonRepositoryDetailInterface

    init {
        pokemonRepositoryDetail = PokemonRepositoryDetail(this)
        pokemonRepositoryDetail.getPokemonDetails(Position.position!!)
    }

    override fun showPokemonDetails(pokemonDetailData: PokemonDetailData) {
        Log.d("PokemonDetailPresenter", "pokemonDetailList: $pokemonDetailData")
        viewState.showPokemonDetails(pokemonDetailData)
    }
}