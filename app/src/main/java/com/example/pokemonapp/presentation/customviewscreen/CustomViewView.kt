package com.example.pokemonapp.presentation.customviewscreen

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface CustomViewView : MvpView {
    fun drawShape()
}