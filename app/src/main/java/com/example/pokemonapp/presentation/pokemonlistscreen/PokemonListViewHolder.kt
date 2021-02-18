package com.example.pokemonapp.presentation.pokemonlistscreen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.model.Result
import kotlinx.android.synthetic.main.rv_text_row.view.*

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