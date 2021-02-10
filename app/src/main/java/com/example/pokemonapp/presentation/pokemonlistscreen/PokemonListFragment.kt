package com.example.pokemonapp.presentation.pokemonlistscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.PokemonResponseData
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.di.DaggerPokemonListPresenterComponent
import kotlinx.android.synthetic.main.pokemon_list_fragment.*
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class PokemonListFragment : MvpAppCompatFragment(), PokemonListView {

    @Inject
    lateinit var pokemonListPresenter: PokemonListPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerPokemonListPresenterComponent.create().inject(this)

        pokemonListPresenter.onGetPokemonsListAction()
        pokemonListPresenter.attachView(this)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)

    }

    override fun showPokemonsList(pokemonResponseData: PokemonResponseData) {
        recyclerView.adapter = pokemonResponseData.results?.let { PokemonListAdapter(it) }
    }

    override fun showErrorMessage() {
        Toast.makeText(context, "Error response!", Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessMessage() {
        Toast.makeText(context, "Success response!", Toast.LENGTH_SHORT).show()
    }
}