package com.example.pokemonapp.presentation.pokemondetailsscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pokemonapp.App
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.PokemonDetailData
import com.example.pokemonapp.di.component.DaggerApplicationComponent
import com.example.pokemonapp.di.modules.FragmentModule
import com.example.pokemonapp.navigation.Screens
import com.example.pokemonapp.repository.PokemonRepository
import com.example.pokemonapp.repository.PokemonRepositoryDetail
import kotlinx.android.synthetic.main.pokemon_detail_fragment.*
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class PokemonDetailFragment : MvpAppCompatFragment(), PokemonDetailView {

    @Inject
    lateinit var pokemonDetailPresenter: PokemonDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PokemonDetailFragment", "onCreate()")
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonDetailPresenter.attachView(this)
        Log.d("PokemonDetailFragment", "attachView() POSITION: = ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pokemonDetailPresenter.detachView(this)
        Log.d("PokemonDetailFragment", "onDestroyView()")
        pokemonDetailPresenter.onDestroy()
    }

    override fun showPokemonDetails(pokemonDetailData: PokemonDetailData) {
        Log.d("PokemonDetailFragment", "showPokemonDetails() : $pokemonDetailData")
        Toast.makeText(
            requireContext(),
            "Pokemod Detail info: $pokemonDetailData",
            Toast.LENGTH_LONG
        ).show()
        bindDetailData(pokemonDetailData)
    }

    private fun bindDetailData(pokemonDetailData: PokemonDetailData) {
        Log.d("PokemonDetailFragment", "bindDetailData() : $pokemonDetailData")
        idTextView.text = pokemonDetailData.id.toString()
        orderTextView.text = pokemonDetailData.order.toString()
        nameTextView.text = pokemonDetailData.name
        heightTextView.text = pokemonDetailData.height.toString()
        weightTextView.text = pokemonDetailData.weight.toString()
        baseExperienceTextView.text = pokemonDetailData.base_experience.toString()
    }

    private fun injectDependency() {
        val pokemonDetailFragmentComponent = DaggerApplicationComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()

        pokemonDetailFragmentComponent.inject(this)
    }


}