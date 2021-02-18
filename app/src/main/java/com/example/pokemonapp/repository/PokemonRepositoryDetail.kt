package com.example.pokemonapp.repository

import com.example.pokemonapp.data.model.PokemonDetailData
import com.example.pokemonapp.network.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PokemonRepositoryDetail(
    private val onPokemonDetailsFetched:
    OnPokemonDetailsFetched
) : PokemonRepositoryDetailInterface {

    interface OnPokemonDetailsFetched {
        fun showPokemonDetails(pokemonDetailData: PokemonDetailData)
    }

    override fun getPokemonDetails(position: Int) {
        getObservableDetail(position)?.subscribeWith(getObserverDetail())
    }

    private fun getObservableDetail(position: Int): Observable<PokemonDetailData>? {
        return RetrofitInstance.buildService()
            .getPokemonDetails(position)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getObserverDetail(): DisposableObserver<PokemonDetailData> {
        return object : DisposableObserver<PokemonDetailData>() {
            override fun onNext(pokemonDetailData: PokemonDetailData?) {
                if (pokemonDetailData != null) {
                    onPokemonDetailsFetched.showPokemonDetails(pokemonDetailData)
                }
            }

            override fun onError(e: Throwable?) {
               // Log.d("PokemonRepository", "Error: $e")
            }

            override fun onComplete() {
               // Log.d("PokemonRepository", "Observer Detail Completed")
            }
        }
    }

    override fun dispose() {
        getObserverDetail().dispose()
    }

}