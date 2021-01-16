package com.example.pokeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pokeapp.R
import com.example.pokeapp.adapter.PokemonFavoritoListAdapter
import com.example.pokeapp.viewmodels.FavoritoViewModel
import kotlinx.android.synthetic.main.fragment_favorito.*

class FavoritoFragment : Fragment() {

    val viewModel: FavoritoViewModel by  viewModels()
    private val adapter = PokemonFavoritoListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorito, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFavoritoRecyclerView.adapter = adapter

        viewModel.getAllFavorites().observe(viewLifecycleOwner){ pokemonfavoritelist ->
           // favoritetext.text = "Nombre: ${pokemonfavoritelist.size}"
            adapter.pokemonfav = pokemonfavoritelist
        }
    }

}