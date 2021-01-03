package com.example.pokeapp.network

import com.example.pokeapp.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonResponse>
}