package com.example.shakeit.model

import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("idDrink")
    val idDrink: String,
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,
    @SerializedName("strAlcoholic")
    val strAlcoholic: String
)
