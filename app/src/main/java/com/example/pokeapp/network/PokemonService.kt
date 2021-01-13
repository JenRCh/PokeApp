package com.example.pokeapp.network

import com.example.pokeapp.models.DetallePokemonResponse
import com.example.pokeapp.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Path


interface PokemonService {
    @GET("pokemon")
    fun getPokemonList(): Observable<PokemonResponse>

    @GET
    ("pokemon/{name}/")
    fun getPokemonDetalle(@Path("name") name:String): Observable<DetallePokemonResponse>
}


