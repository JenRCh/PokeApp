package com.example.pokeapp.models

data class DetallePokemonResponse( //val abilities: List<abilitiesModel>,
                                 val base_experience:Int,
//                                  val forms: List<formsModel>,
//                                  val game_indices: List<gameModel>,
                                 val height:Int,
                                  val id:Int,
//                                  val is_default:Boolean,
//                                  val location_area_encounters:String,
                                  val name:String,
                                  val order:Int,
//                                  val species:speciesModel,
                                 val sprites: spritesModel)
                                 // val weight:Int)