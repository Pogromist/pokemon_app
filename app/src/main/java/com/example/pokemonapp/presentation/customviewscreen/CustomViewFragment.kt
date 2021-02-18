package com.example.pokemonapp.presentation.customviewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonapp.App
import com.example.pokemonapp.R
import com.example.pokemonapp.di.component.DaggerApplicationComponent
import com.example.pokemonapp.di.modules.FragmentModule
import com.example.pokemonapp.navigation.Screens
import kotlinx.android.synthetic.main.custom_view_fragment.*
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class CustomViewFragment : MvpAppCompatFragment(), CustomViewView {

    @Inject
    lateinit var customViewPresenter: CustomViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        customViewPresenter.attachView(this)
        btnDraw.setOnClickListener {
            drawShape()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        customViewPresenter.detachView(this)
        customViewPresenter.onDestroy()
    }

    override fun drawShape() {
        customViewPresenter.onDrawButtonClicked(requireContext())
    }

    private fun injectDependency() {
        val customViewFragmentComponent = DaggerApplicationComponent
            .builder()
            .fragmentModule(FragmentModule())
            .build()

        customViewFragmentComponent.inject(this)
    }
}