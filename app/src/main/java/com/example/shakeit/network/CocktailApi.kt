package com.example.shakeit.network

import com.example.shakeit.model.network.CocktailListResponse
import com.example.shakeit.model.network.DrinkInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktailList(): Response<CocktailListResponse>

    @GET("filter.php?a=Alcoholic")
    suspend fun getAlcoholicDrinks(): Response<CocktailListResponse>

    @GET("filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicDrinks(): Response<CocktailListResponse>

    @GET("lookup.php")
    suspend fun getCocktailInfo(@Query("i") idDrink: String): Response<DrinkInfo>

    companion object {
        const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    }
}