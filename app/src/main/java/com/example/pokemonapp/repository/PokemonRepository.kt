package com.example.pokemonapp.repository

import android.util.Log
import com.example.pokemonapp.data.model.PokemonNameData
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.network.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PokemonRepository(private val onPokemonsFetchedListener: OnPokemonsFetchedListener) :
    PokemonRepositoryInterface {

    private var pokemonList: List<Result>? = null

    override fun getPokemonsList() {
        Log.d("PokemonRepository", "getPokemonsList()")
        getObservable()?.subscribeWith(getObserver())
        //getObserver().dispose()
    }

    override fun getPokemonDetails(position: Int) {
        TODO("Not yet implemented")
    }

    /*override fun getPokemonDetails(position: Int) {
        getObservableDetail(position)?.subscribeWith(getObserverDetail())
    }*/

    private fun getObservable(): Observable<PokemonNameData>? {
        Log.d("PokemonRepository", "getObservable()")

        return RetrofitInstance.buildService()
            .getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getObserver(): DisposableObserver<PokemonNameData> {
        return object : DisposableObserver<PokemonNameData>() {
            override fun onNext(pokemonNameData: PokemonNameData?) {
                if (pokemonNameData != null) {
                    pokemonNameData.results?.let { onPokemonsFetchedListener.showPokemonsList(it) }
                    Log.d("PokemonRepository", "POKEMON RESPONSE DATA: " +
                            "${pokemonNameData.results}")
                }
            }

            override fun onError(e: Throwable?) {
                Log.d("PokemonRepository", "Error: $e")
            }

            override fun onComplete() {
                Log.d("PokemonRepository", "Completed")
            }
        }
    }

    /*private fun getObservableDetail(position: Int): Observable<PokemonDetailData>? {
        return RetrofitInstance.buildService()
            .getPokemonDetails(position)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getObserverDetail(): DisposableObserver<PokemonDetailData> {
        return object : DisposableObserver<PokemonDetailData>() {
            override fun onNext(pokemonDetailData: PokemonDetailData?) {
                if (pokemonDetailData != null) {
                    viewState.showPokemonDetails(pokemonDetailData)
                } else {
                    viewState.showErrorMessage()
                }
            }

            override fun onError(e: Throwable?) {
                Log.d("PokemonRepository", "Error: $e")
                viewState.showErrorMessage()
            }

            override fun onComplete() {
                Log.d("PokemonRepository", "Completed")
            }
        }
    }*/

    interface OnPokemonsFetchedListener {
        fun showPokemonsList(pokemonNameData: List<Result>)
    }

}