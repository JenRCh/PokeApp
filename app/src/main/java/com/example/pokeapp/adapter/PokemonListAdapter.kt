package com.example.pokeapp.adapter

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapp.R
import com.example.pokeapp.models.DetallePokemonResponse
import com.example.pokeapp.models.Pokemon
import kotlinx.android.synthetic.main.pokemon_cell.view.*

class PokemonListAdapter(val clickListener: (DetallePokemonResponse) -> Unit) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewMolder>() {

    var pokemonList: List<DetallePokemonResponse> = emptyList()
    set(value){
        field = value
       // notifyDataSetChanged()
    }

    inner class PokemonViewMolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(pokemon: DetallePokemonResponse){
            itemView.nameTextView.text = pokemon.name
            Glide.with(itemView.context)
                    .load(pokemon.sprites.front_default.toString())
                    .circleCrop()
                    .into(itemView.pokemonImageView)

            val isFavorite = R.drawable.ic_baseline_star_outline_24
            itemView.star.setImageResource(isFavorite)
//            Glide.with(itemView.context)
//                    .load(isFavorite)
//                    .into(itemView.star)

            itemView.setOnClickListener{
                clickListener.invoke(pokemon)
            }
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