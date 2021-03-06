package com.example.pokeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.pokeapp.R
import com.example.pokeapp.adapter.PokemonTabAdapter
import com.example.pokeapp.extensions.toTabTitle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_logeo.*

class HomeFragment : Fragment() {

    private val args:HomeFragmentArgs by navArgs()
    private lateinit var adapter : PokemonTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PokemonTabAdapter(this)
        pokemonViewPager.adapter = adapter

        TabLayoutMediator(tabLayout,pokemonViewPager){tab,position ->
            tab.text = position.toTabTitle()
        }.attach()
    }
}