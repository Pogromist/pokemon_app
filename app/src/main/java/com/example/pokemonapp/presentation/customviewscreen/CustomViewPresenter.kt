package com.example.pokemonapp.presentation.customviewscreen

import android.content.Context
import com.example.pokemonapp.views.CustomView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CustomViewPresenter @Inject constructor() : MvpPresenter<CustomViewView>() {
    fun onDrawButtonClicked(context: Context) {
        val customView = CustomView(context)
        customView.drawShape()
    }
}