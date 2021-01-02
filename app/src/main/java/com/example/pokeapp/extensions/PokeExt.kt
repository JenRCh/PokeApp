package com.example.pokeapp.extensions

import androidx.fragment.app.Fragment
import com.example.pokeapp.fragments.FavoritoFragment
import com.example.pokeapp.fragments.ListaFragment

fun Int.toFragment():Fragment{
    return when(this){
        0-> ListaFragment()
        else -> FavoritoFragment()
    }
}

fun Int.toTabTitle() :String{
    return when(this){
        0-> "Pokemon"
        else -> "Favorito"
    }
}