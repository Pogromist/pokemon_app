package com.example.pokemonapp.presentation.pokemonlistscreen

import android.util.Log
import com.example.pokemonapp.data.model.PokemonResponseData
import com.example.pokemonapp.network.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PokemonListPresenter @Inject constructor(): MvpPresenter<PokemonListView>() {

    fun onGetPokemonsListAction() {
        getObservable()?.subscribeWith(getObserver())
    }

    private fun getObservable(): Observable<PokemonResponseData>? {
        return RetrofitInstance.buildService()
            .getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getObserver() : DisposableObserver<PokemonResponseData> {
        return object : DisposableObserver<PokemonResponseData>() {
            override fun onNext(pokemonResponseData: PokemonResponseData?) {
                if (pokemonResponseData != null) {
                    viewState.showPokemonsList(pokemonResponseData)
                }
                else {
                    viewState.showErrorMessage()
                }
            }

            override fun onError(e: Throwable?) {
                Log.d("PokemonListPresenter", "Error: $e")
                viewState.showErrorMessage()
            }

            override fun onComplete() {
                Log.d("PokemonListPresenter", "Completed")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PokemonListPresenter", "dispose()")
        getObserver().dispose()
    }
}