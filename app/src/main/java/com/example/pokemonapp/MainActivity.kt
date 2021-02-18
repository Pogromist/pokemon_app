package com.example.pokemonapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonapp.navigation.Screens
import com.example.pokemonapp.views.CustomView
import com.github.terrakok.cicerone.androidx.AppNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.frameLayout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.INSTANCE.router.replaceScreen(Screens.PokemonListScreen())

        val customView = CustomView(this)

        Log.d("PokemonMainActivity", "replaceScreen()")

        bottomNavigationMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pokemonListFragment -> App.INSTANCE.router.replaceScreen(Screens.PokemonListScreen())
                R.id.customViewFragment -> App.INSTANCE.router.replaceScreen(Screens.CustomViewScreen())
            }
            true
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
        Log.d("PokemonMainActivity", "onResumeFragments()")
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        Log.d("PokemonMainActivity", "onPause()")
        super.onPause()
    }
}