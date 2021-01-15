package com.example.pokeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pokeapp.R
import kotlinx.android.synthetic.main.fragment_detalle.*
import kotlinx.android.synthetic.main.pokemon_cell.view.*


class DetalleFragment : Fragment() {

    private val args : DetalleFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName.text = args.PokeInfo.name.toString();
        textViewWeightPoke.text = args.PokeInfo.weight.toString();
        textViewHeightPoke.text = args.PokeInfo.height.toString();
        Glide.with(this)
                .load(args.PokeInfo.image.toString())
                .circleCrop()
                .into(imageViewPokemon)
    }

}