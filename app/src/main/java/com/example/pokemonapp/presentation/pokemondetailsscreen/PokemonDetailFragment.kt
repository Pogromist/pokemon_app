package com.example.pokemonapp.presentation.pokemondetailsscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.PokemonDetailData
import com.example.pokemonapp.di.component.DaggerApplicationComponent
import com.example.pokemonapp.di.modules.FragmentModule
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
        Log.d("PokemonDetailFragment", "onCreateView()")
        return inflater.inflate(R.layout.pokemon_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonDetailPresenter.attachView(this)
        Log.d("PokemonDetailFragment", "onViewCreated()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pokemonDetailPresenter.detachView(this)
        Log.d("PokemonDetailFragment", "onDestroyView()")
        pokemonDetailPresenter.onDestroy()
    }

    override fun showPokemonDetails(pokemonDetailData: PokemonDetailData) {
        bindDetailData(pokemonDetailData)
    }

    @SuppressLint("SetTextI18n")
    private fun bindDetailData(pokemonDetailData: PokemonDetailData) {
        idTextView.text = "ID: " + pokemonDetailData.id.toString()
        orderTextView.text = "Order: " + pokemonDetailData.order.toString()
        nameTextView.text = "Name: " + pokemonDetailData.name
        heightTextView.text = "Height: " + pokemonDetailData.height.toString()
        weightTextView.text = "Weight: " + pokemonDetailData.weight.toString()
        baseExperienceTextView.text = "Base experience: " + pokemonDetailData.base_experience.toString()
    }

    private fun injectDependency() {
        val pokemonDetailFragmentComponent = DaggerApplicationComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()

        pokemonDetailFragmentComponent.inject(this)
    }


}