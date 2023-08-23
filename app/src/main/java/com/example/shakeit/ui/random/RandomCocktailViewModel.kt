package com.example.shakeit.ui.random


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shakeit.model.Drink
import com.example.shakeit.model.DrinkDetails
import com.example.shakeit.network.CocktailApi
import com.example.shakeit.repository.FavoriteDrinkRepository
import com.example.shakeit.repository.RandomCocktailRepository
import com.example.shakeit.util.DrinkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class RandomCocktailViewModel @Inject constructor(
    private val randomCocktailRepository: RandomCocktailRepository,
    private val favoriteDrinkRepository: FavoriteDrinkRepository,
    private val cocktailApi: CocktailApi,
) : ViewModel() {

    val randomCocktail = MutableLiveData<DrinkDetails>()

    fun getRandomCocktail() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = cocktailApi.getRandomCocktail()
            if (!response.isSuccessful) {
                Log.e("API Error", "Failed to fetch additional data")
            } else {
                val cocktailByID = response.body()
                randomCocktail.postValue(cocktailByID?.drinks?.firstOrNull())
            }
        }
    }
    private val drinkUtils: DrinkUtils =
        DrinkUtils(favoriteDrinkRepository, cocktailApi, viewModelScope)

    fun addDrinkToFavorites() {
        val drink = randomCocktail.value
        drinkUtils.addFavoriteDrink(
            Drink(
                drink?.idDrink ?: "",
                drink?.strDrink ?: "",
                drink?.strDrinkThumb ?: ""
            )
        )
    }
}
