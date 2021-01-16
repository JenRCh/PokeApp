package com.example.pokeapp.models

data class DetallePokemonResponse(
                                 val base_experience:Int,
                                 val height:Int,
                                 val id:Int,
                                 val name:String,
                                 val order:Int,
                                 val weight:Int,
                                 val sprites: spritesModel)