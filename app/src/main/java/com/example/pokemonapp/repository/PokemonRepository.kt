package com.example.pokemonapp.repository

import com.example.pokemonapp.data.model.PokemonNameData
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.network.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PokemonRepository(
    private val onPokemonListFetched:
    OnPokemonListFetched
) : PokemonRepositoryInterface {

    override fun getPokemonsList() {
        getObservable()?.subscribeWith(getObserver())
    }

    private fun getObservable(): Observable<PokemonNameData>? {
        return RetrofitInstance.buildService()
            .getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getObserver(): DisposableObserver<PokemonNameData> {
        return object : DisposableObserver<PokemonNameData>() {
            override fun onNext(pokemonNameData: PokemonNameData?) {
                if (pokemonNameData != null) {
                    pokemonNameData.results?.let { onPokemonListFetched.showPokemonsList(it) }
                }
            }

            override fun onError(e: Throwable?) {
                //Log.d("PokemonRepository", "Error: $e")
            }

            override fun onComplete() {
               // Log.d("PokemonRepository", "Completed")
            }
        }
    }

    override fun savePosition(position: Int) {
        UtilObject.position = position
    }

    override fun disposeAll() {
        getObserver().dispose()
    }

    interface OnPokemonListFetched {
        fun showPokemonsList(pokemonNameData: List<Result>)
    }
}

object UtilObject {
    var position: Int? = null
    var flag: Boolean? = null
    var isFirstTimeCreated = true
}