package com.example.pokeapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDAO {
    @Insert
    suspend fun insertFavorite(pokemondb : PokemonDB)

    @Query("SELECT * FROM pokemondb")
    fun getAllFavorite() : Flow<List<PokemonDB>>
}