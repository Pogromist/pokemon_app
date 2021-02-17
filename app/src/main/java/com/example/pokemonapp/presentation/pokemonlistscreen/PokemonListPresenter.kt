package com.example.pokemonapp.presentation.pokemonlistscreen

import android.util.Log
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.repository.PokemonRepository
import com.example.pokemonapp.repository.PokemonRepositoryInterface
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PokemonListPresenter @Inject constructor() : MvpPresenter<PokemonListView>(),
    PokemonRepository.OnPokemonListFetched
{

    private var pokemonRepository: PokemonRepositoryInterface

    init {
        pokemonRepository = PokemonRepository(this)
        pokemonRepository.getPokemonsList()
        Log.d("PokemonListPresenter", "getPokemonsList()")
    }

    override fun showPokemonsList(pokemonNameData: List<Result>) {
        viewState.showPokemonsList(pokemonNameData)
    }

    override fun onDestroy() {
        super.onDestroy()
        pokemonRepository.disposeAll()
    }

    fun onItemClicked(position: Int) {
        Log.d("PokemonListPresenter", "onItemClicked($position)")
        pokemonRepository.savePosition(position)
    }
}