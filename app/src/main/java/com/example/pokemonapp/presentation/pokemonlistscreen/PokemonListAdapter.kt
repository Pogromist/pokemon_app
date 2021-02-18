package com.example.pokemonapp.presentation.pokemonlistscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.Result

class PokemonListAdapter(private val pokemonsList: List<Result>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemClickListener: OnItemCLickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PokemonListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_text_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PokemonListViewHolder
        viewHolder.bind(pokemonsList[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return pokemonsList.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemCLickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemCLickListener {
        fun onItemCLick(position: Int)
    }

}