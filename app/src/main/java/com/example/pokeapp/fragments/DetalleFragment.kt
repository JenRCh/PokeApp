package com.example.pokeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pokeapp.R
import com.example.pokeapp.db.PokemonDB
import com.example.pokeapp.viewmodels.PokemonListViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_detalle.*
import kotlinx.android.synthetic.main.fragment_lista.*
import kotlinx.android.synthetic.main.pokemon_cell.view.*


class DetalleFragment : Fragment() {
    private val viewModel : PokemonListViewModel by viewModels()

    private val args : DetalleFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName.text = args.PokeInfo.name.toString();
        textViewWeightPoke.text = args.PokeInfo.weight.toString();
        textViewHeightPoke.text = args.PokeInfo.height.toString();
        textVieworden.text = args.PokeInfo.order.toString();
        textViewbase.text = args.PokeInfo.base_experience.toString()
        Glide.with(this)
                .load(args.PokeInfo.image.toString())
                .circleCrop()
                .into(imageViewPokemon)

        buttonAgregar.setOnClickListener{
            viewModel.insertFavorite(PokemonDB(
                    args.PokeInfo.id,args.PokeInfo.weight,args.PokeInfo.height,args.PokeInfo.name,
                    args.PokeInfo.image,args.PokeInfo.base_experience,args.PokeInfo.order ))
        }

    }

}