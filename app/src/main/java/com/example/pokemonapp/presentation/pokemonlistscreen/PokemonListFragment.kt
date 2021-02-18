package com.example.pokemonapp.presentation.pokemonlistscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pokemonapp.App
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.di.component.DaggerApplicationComponent
import com.example.pokemonapp.di.modules.FragmentModule
import com.example.pokemonapp.navigation.Screens
import kotlinx.android.synthetic.main.pokemon_list_fragment.*
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class PokemonListFragment : MvpAppCompatFragment(),
    PokemonListView {

    @Inject
    lateinit var pokemonListPresenter: PokemonListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PokemonListFragment", "onCreate()")
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("PokemonListFragment", "onCreateView()")
        return inflater.inflate(R.layout.pokemon_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonListPresenter.attachView(this)
        Log.d("PokemonListFragment", "onViewCreated()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("PokemonListFragment", "onDestroyView()")
        pokemonListPresenter.detachView(this)
        pokemonListPresenter.onDestroy()
    }

    override fun showPokemonsList(pokemonResponseData: List<Result>) {
        //Log.d("PokemonListFragment", "showPokemonsList()")
        val adapter = PokemonListAdapter(pokemonResponseData)
        adapter.setOnItemClickListener(object : PokemonListAdapter.OnItemCLickListener {
            override fun onItemCLick(position: Int) {
                //Log.d("PokemonListFragment", "onItemClick($position)")
                App.INSTANCE.router.navigateTo(Screens.PokemonDetailScreen())
                pokemonListPresenter.onItemClicked(position)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun showSuccessMessage() {
        Toast.makeText(context, "Success response!", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessage() {
        Toast.makeText(context, "Error response!", Toast.LENGTH_SHORT).show()
    }

    private fun injectDependency() {
        val pokemonListFragmentComponent = DaggerApplicationComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()

        pokemonListFragmentComponent.inject(this)
    }
}