package com.example.shakeit.repository

import com.example.shakeit.network.CocktailApi
import javax.inject.Inject

class RandomCocktailRepository @Inject constructor(
    private val cocktailApi: CocktailApi
) {
    suspend fun getRandomCocktail() = cocktailApi.getRandomCocktail()
}