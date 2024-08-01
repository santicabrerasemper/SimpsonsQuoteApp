package com.example.thesimpsonsquoteapp.models

import com.google.gson.annotations.SerializedName

data class SimpsonCharacter(
    @SerializedName("quote")
    val quote: String,
    @SerializedName("character")
    val character: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("characterDirection")
    val characterDirection: String
)
