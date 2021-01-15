package com.example.pokeapp.models

import android.os.Parcel
import android.os.Parcelable

data class PokemonInfo (val base_experience:Int, val height:Int, val id:Int,
                        val name:String,val order:Int,val image:String) : Parcelable{
                              constructor(parcel: Parcel): this (
                                      (parcel.readString() ?: 0) as Int,
                                      (parcel.readString()  ?: 0) as Int,
                                      (parcel.readString()  ?: 0) as Int,
                                      parcel.readString() ?: "",
                                      (parcel.readString() ?: 0) as Int,
                                      parcel.readString() ?: "",
                              ) {  }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(base_experience)
        parcel.writeInt(height)
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(order)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonInfo> {
        override fun createFromParcel(parcel: Parcel): PokemonInfo {
            return PokemonInfo(parcel)
        }

        override fun newArray(size: Int): Array<PokemonInfo?> {
            return arrayOfNulls(size)
        }
    }
}