package com.example.pokemonapp.presentation.pokemonlistscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.PokemonNameData
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
        pokemonListPresenter.attachView(this)
        Log.d("PokemonListFragment", "attachView()")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        pokemonListPresenter.detachView(this)
        pokemonListPresenter.onDestroy()
    }

    override fun showPokemonsList(pokemonResponseData: List<Result>) {
        Log.d("PokemonListFragment", "showPokemonsList()")
        val adapter = PokemonListAdapter(pokemonResponseData)
        adapter.setOnItemClickListener(object: PokemonListAdapter.OnItemCLickListener {
            override fun onItemCLick(position: Int) {
                pokemonListPresenter.onItemClicked(position)
            }
        })
        recyclerView.adapter = adapter

    }

    override fun onPokemonClicked() {
        Toast.makeText(requireContext(), "Pokemon Clicked",Toast.LENGTH_LONG).show()
    }

    override fun showSuccessMessage() {
        Toast.makeText(context, "Success response!", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessage() {
        Toast.makeText(context, "Error response!", Toast.LENGTH_SHORT).show()
    }
}