package com.example.shakeit.model.network

import com.example.shakeit.model.Drink
import com.google.gson.annotations.SerializedName

data class CocktailListResponse(
    @SerializedName("drinks")
    val drinks: ArrayList<Drink>
)