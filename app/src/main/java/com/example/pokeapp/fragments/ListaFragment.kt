package com.example.pokeapp.fragments

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pokeapp.R
import com.example.pokeapp.adapter.PokemonListAdapter
import com.example.pokeapp.db.PokemonDB
import com.example.pokeapp.models.PokemonInfo
import com.example.pokeapp.models.User
import com.example.pokeapp.viewmodels.PokemonListViewModel
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_lista.*
import kotlinx.android.synthetic.main.pokemon_cell.*


class ListaFragment : Fragment() {
    private val viewModel : PokemonListViewModel by viewModels()
    private val adapter = PokemonListAdapter{pokemon ->
        val action1 = HomeFragmentDirections.actionHomeFragmentToDetalleFragment(PokemonInfo(pokemon.base_experience,pokemon.weight,
        pokemon.height,pokemon.id,pokemon.name,pokemon.order,pokemon.sprites.front_default))
        findNavController().navigate(action1)

        viewModel.insertFavorite(PokemonDB(pokemon.id,pokemon.weight,pokemon.height,pokemon.name,
                pokemon.sprites.front_default,pokemon.base_experience,pokemon.order))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.getPokemonList()
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonRecyclerView.adapter = adapter
        pokemonRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(),
            DividerItemDecoration.VERTICAL ))

//        viewModel.getPokemonListResponse().observe(viewLifecycleOwner){ pokemonList ->
//           // Log.d("Imprimir",pokemonList.toString())
//            adapter.pokemonList = pokemonList
//            pokemonRecyclerView.visibility = View.VISIBLE
//        }

        viewModel.getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
                .doOnError { error ->
                    Log.d("getPokemonList", error.toString())
                }
                .onErrorReturn { emptyList() }
            .subscribe{ pokemonList ->
                adapter.pokemonList = pokemonList
                pokemonRecyclerView.visibility = View.VISIBLE
            }

        viewModel.getIsLoading().observe(viewLifecycleOwner){ isLoading ->
            progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
        }

        viewModel.getIsError().observe(viewLifecycleOwner){ isError ->
            Snackbar.make(parent,R.string.error_text,Snackbar.LENGTH_LONG).show()

        }
    }
}