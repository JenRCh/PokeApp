package com.example.pokeapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapp.models.DetallePokemonResponse
import com.example.pokeapp.models.Pokemon
import com.example.pokeapp.models.PokemonResponse
import com.example.pokeapp.network.RetrofitProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import io.reactivex.rxjava3.core.Observable


class PokemonListViewModel : ViewModel(){
    val retrofitProvider = RetrofitProvider()
    private val offset: Int = 210
    private val limit: Int = 20

   // private val pokemonListResponse: MutableLiveData<List<Pokemon>> = MutableLiveData()
    private val isMakingRequest: MutableLiveData<Boolean> = MutableLiveData()
    private val isError: MutableLiveData<Boolean> = MutableLiveData()

//    fun getPokemonListResponse() :LiveData<List<Pokemon>>{
//        return pokemonListResponse
//    }

    fun getIsLoading() :LiveData<Boolean>{
        return isMakingRequest
    }

    fun getIsError() :LiveData<Boolean>{
        return isError
    }

    fun getPokemonList(): Observable<List<DetallePokemonResponse>> {
        isMakingRequest.postValue(true)
        return retrofitProvider.getPokemonService().getPokemonList(offset,limit)
                .map { response -> response.results }
                .flatMapIterable { list -> list }
                .flatMap { item ->
                   retrofitProvider.getPokemonService().getPokemonDetalle(item.name)
                           .map { detailResponse -> detailResponse }
                            .doOnError { error ->
                                Log.d("error", error.toString())
                               isError.postValue(true)
                               isMakingRequest.postValue(false)
                           }
                            .onErrorReturn { error -> throw error }
               }
              // .sorted { first, second -> first.id.compareTo(second.id) }
                .toList()
                .toObservable()
                .doOnNext {
                   isMakingRequest.postValue(false)
               }

          //  .doOnNext{ isMakingRequest.postValue(false)}

//                .enqueue(object :
//            Callback<PokemonResponse>{
//            override fun onResponse(
//                call: Call<PokemonResponse>,
//                response: Response<PokemonResponse>
//            ) {
//                isMakingRequest.postValue(false)
//                if(response.isSuccessful){
//                    response.body()?.let { unwrappedResponse ->
//                       // Log.d("Lista", unwrappedResponse.toString())
//                        pokemonListResponse.postValue(unwrappedResponse.results)
//                    }
//                }else{
//                    isError.postValue(true)
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
//                isMakingRequest.postValue(false)
//                isError.postValue(true)
//            }
//        })
    }
}