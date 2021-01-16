package com.example.pokeapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDB (
        @PrimaryKey val id:Int,
        @ColumnInfo(name="Weight") val weight:Int,
        @ColumnInfo(name="Height") val height:Int,
        @ColumnInfo(name="Name") val name:String,
        @ColumnInfo(name="Image") val image:String,
        @ColumnInfo(name="Base") val base_experience:Int,
        @ColumnInfo(name="Order") val order:Int,
        )