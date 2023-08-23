package com.example.shakeit.repository

import com.example.shakeit.network.CocktailApi
import javax.inject.Inject

class CocktailListRepository @Inject constructor(
    private val cocktailApi: CocktailApi
) {
    suspend fun getAllCocktailList() = cocktailApi.getCocktailList()

}