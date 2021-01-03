package com.example.pokeapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pokeapp.models.PokemonResponse
import com.example.pokeapp.network.RetrofitProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonListViewModel : ViewModel(){
    val retrofitProvider = RetrofitProvider()

    fun getPokemonList(){
        retrofitProvider.getPokemonService().getPokemonList().enqueue(object :
            Callback<PokemonResponse>{
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let { unwrappedResponse ->
                        Log.d("Lista", unwrappedResponse.toString())
                    }

                }else{
                    //funcionalidad para error
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
               //funcionalidad para error
            }
        })
    }
}