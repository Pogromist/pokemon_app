package com.example.pokemonapp.presentation.pokemonlistscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.data.model.PokemonNameData
import com.example.pokemonapp.data.model.Result
import kotlinx.android.synthetic.main.rv_text_row.view.*

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

/*class PokemonListAdapter(private val values: List<Result>) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        return PokemonListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_text_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.itemView.apply {
            pokemonName.text = values[position].name
        }
    }

    override fun getItemCount() = values.size

    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}*/