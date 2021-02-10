package com.example.pokemonapp.presentation.pokemondetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonapp.R
import com.example.pokemonapp.di.DaggerPokemonDetailPresenterComponent
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class PokemonDetailFragment : MvpAppCompatFragment(), PokemonDetailView {

    @Inject
    lateinit var pokemonDetailPresenter: PokemonDetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerPokemonDetailPresenterComponent.create().inject(this)
        pokemonDetailPresenter.attachView(this)
    }

    override fun showPokemonDetails() {
        TODO("Not yet implemented")
    }
}