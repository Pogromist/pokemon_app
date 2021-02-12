package com.example.pokemonapp.presentation.pokemonlistscreen

import android.util.Log
import com.example.pokemonapp.data.model.PokemonNameData
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.repository.PokemonRepository
import com.example.pokemonapp.repository.PokemonRepositoryInterface
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PokemonListPresenter @Inject constructor(): MvpPresenter<PokemonListView>(), PokemonRepository.OnPokemonsFetchedListener {

    private var pokemonRepository: PokemonRepositoryInterface
    private var pokemonList: List<Result>? = null

    init {
        pokemonRepository = PokemonRepository(this)
        pokemonRepository.getPokemonsList()
        Log.d("PokemonListPresenter", "getPokemonsList()")
    }

    fun onGetPokemonsListAction(pokemonResponseData: PokemonNameData) {
        pokemonRepository.getPokemonsList()
        //viewState.showPokemonsList(pokemonResponseData.result)
    }

    override fun showPokemonsList(pokemonNameData:  List<Result>) {
        pokemonList = pokemonNameData
        viewState.showPokemonsList(pokemonList!!)
    }


    /*override fun onDestroy() {
        super.onDestroy()
        getObserver().dispose()
    }*/


}