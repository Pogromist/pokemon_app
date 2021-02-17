package com.example.pokemonapp.presentation.pokemonlistscreen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.model.Result
import com.example.pokemonapp.presentation.pokemondetailsscreen.PokemonDetailPresenter
import kotlinx.android.synthetic.main.rv_text_row.view.*
import javax.inject.Inject

class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        pokemonNameData: Result,
        onItemClickListener: PokemonListAdapter.OnItemCLickListener?
    ) {
        itemView.pokemonName.text = pokemonNameData.name
        itemView.setOnClickListener {
            onItemClickListener!!.onItemCLick(adapterPosition + 1)
        }
    }

}