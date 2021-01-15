package com.example.pokeapp.repository

import com.example.pokeapp.db.PokemonDAO
import com.example.pokeapp.db.PokemonDB
import kotlinx.coroutines.flow.Flow

class PokemonRepository(private val pokemonDAO: PokemonDAO){
    suspend fun insert(pokemonDB: PokemonDB){
        pokemonDAO.insertFavorite(pokemonDB)
    }

    val allFavorites : Flow<List<PokemonDB>> = pokemonDAO.getAllFavorite()

}