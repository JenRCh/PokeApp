package com.example.pokeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapp.R
import com.example.pokeapp.db.PokemonDB
import kotlinx.android.synthetic.main.pokemon_cell.view.*
import kotlinx.android.synthetic.main.pokemon_favorito_cell.view.*

class PokemonFavoritoListAdapter : RecyclerView.Adapter<PokemonFavoritoListAdapter.PokemonFavoritoViewHolder>() {
    var pokemonfav: List<PokemonDB> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    inner class PokemonFavoritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pokemonDB: PokemonDB){
            itemView.textViewHeightFav.text = pokemonDB.height.toString()
            itemView.textViewNameFav.text = pokemonDB.name
            itemView.textViewWeightFav.text = pokemonDB.weight.toString()
            Glide.with(itemView.context)
                    .load(pokemonDB.image)
                    .circleCrop()
                    .into(itemView.imagefavPoke)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonFavoritoViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_favorito_cell,parent,false)
        return PokemonFavoritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonFavoritoViewHolder, position: Int) {
       holder.bind(pokemonfav[position])
    }

    override fun getItemCount() = pokemonfav.size
}