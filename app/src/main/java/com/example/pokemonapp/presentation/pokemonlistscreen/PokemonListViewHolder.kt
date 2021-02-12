package com.example.pokemonapp.presentation.pokemonlistscreen

import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.model.PokemonNameData
import com.example.pokemonapp.data.model.Result
import kotlinx.android.synthetic.main.rv_text_row.view.*

class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemonNameData: Result, onItemClickListener: PokemonListAdapter.OnItemCLickListener?) {
        itemView.pokemonName.text = pokemonNameData.toString()
        itemView.setOnClickListener {
            onItemClickListener!!.onItemCLick(adapterPosition)
        }
    }

}