package com.example.shakeit.network

import com.example.shakeit.model.network.CocktailListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CocktailApi {

    @GET("search.php?f=a")
    suspend fun getListCocktail(): Response<CocktailListResponse>
}