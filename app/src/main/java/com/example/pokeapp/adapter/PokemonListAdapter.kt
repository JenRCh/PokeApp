package com.example.pokeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.models.Pokemon
import kotlinx.android.synthetic.main.pokemon_cell.view.*

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.PokemonViewMolder>() {

    var pokemonList: List<Pokemon> = emptyList()
    set(value){
        field = value
       // notifyDataSetChanged()
    }

    inner class PokemonViewMolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(pokemon: Pokemon){
            itemView.nameTextView.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewMolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_cell,parent,false)
        return PokemonViewMolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewMolder, position: Int) {
      holder.bind(pokemonList[position])
    }

    override fun getItemCount() = pokemonList.size

}