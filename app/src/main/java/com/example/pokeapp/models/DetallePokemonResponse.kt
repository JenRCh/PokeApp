package com.example.pokeapp.models

data class DetallePokemonResponse(val abilities: List<abilitiesModel>,val base_experience:String,val forms: List<formsModel>,
                                  val game_indices: List<gameModel>, val height:Int,val id:Int,val is_default:Boolean,
                                  val location_area_encounters:String,val name:String,val order:Int,
                                  val species:List<speciesModel>, val sprites: List<spritesModel>,val weight:Int)