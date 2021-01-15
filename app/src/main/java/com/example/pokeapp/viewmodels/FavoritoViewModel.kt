package com.example.pokeapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.pokeapp.db.PokemonDAO
import com.example.pokeapp.db.PokemonDB
import com.example.pokeapp.db.PokemonDatabase
import com.example.pokeapp.repository.PokemonRepository

class FavoritoViewModel (application: Application) : AndroidViewModel(application){
    private val repository: PokemonRepository
    private val database: PokemonDatabase = PokemonDatabase.getDatabase(application)

    init {
        repository = PokemonRepository(database.pokemonDao())
    }

    fun getAllFavorites() : LiveData<List<PokemonDB>> = repository.allFavorites.asLiveData()
}