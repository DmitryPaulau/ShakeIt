package com.example.shakeit.network

import com.example.shakeit.model.CocktailByID
import com.example.shakeit.model.CocktailListResponse
import com.example.shakeit.model.RandomCocktailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktailList(): Response<CocktailListResponse>

    @GET("lookup.php")
    suspend fun getCocktailInfo(@Query("i") idDrink: String): Response<CocktailByID>

    @GET("random.php")
    suspend fun getRandomCocktail(): Response<RandomCocktailResponse>
}