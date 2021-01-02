package com.example.pokeapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokeapp.extensions.toFragment
import com.example.pokeapp.fragments.FavoritoFragment
import com.example.pokeapp.fragments.ListaFragment

class PokemonTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount()=2


    override fun createFragment(position: Int): Fragment {
   return position.toFragment()
    }
}