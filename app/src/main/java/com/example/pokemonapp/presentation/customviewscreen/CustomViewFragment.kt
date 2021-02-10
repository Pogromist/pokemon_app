package com.example.pokemonapp.presentation.customviewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonapp.R
import com.example.pokemonapp.di.DaggerCustomViewPresenterComponent
import kotlinx.android.synthetic.main.custom_view_fragment.*
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class CustomViewFragment : MvpAppCompatFragment(), CustomViewView {

    @Inject
    lateinit var customViewPresenter: CustomViewPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        DaggerCustomViewPresenterComponent.create().inject(this)
        customViewPresenter.attachView(this)

        btnDraw.setOnClickListener {
            drawShape()
        }
    }

    override fun drawShape() {
        customViewPresenter.onDrawButtonClicked()
    }
}