package com.example.shakeit.model

import com.google.gson.annotations.SerializedName

data class RandomCocktailResponse(
    @SerializedName("drinks")
    val drinks: ArrayList<DrinkDetails>
)