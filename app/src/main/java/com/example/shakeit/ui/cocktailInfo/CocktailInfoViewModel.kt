package com.example.shakeit.ui.cocktailInfo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shakeit.model.Drink
import com.example.shakeit.model.DrinkDetails
import com.example.shakeit.network.CocktailApi
import com.example.shakeit.repository.FavoriteDrinkRepository
import com.example.shakeit.util.DrinkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailInfoViewModel @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val favoriteDrinkRepository: FavoriteDrinkRepository,
) : ViewModel() {
    val drinkInfo = MutableLiveData<DrinkDetails>()

    fun fetchAdditionalData(idDrink: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = cocktailApi.getCocktailInfo(idDrink)
            if (!response.isSuccessful) {
                Log.e("API Error", "Failed to fetch additional data")
            } else {
                val cocktailByID = response.body()
                drinkInfo.postValue(cocktailByID?.drinks?.firstOrNull())
            }
        }
    }

    private val drinkUtils: DrinkUtils =
        DrinkUtils(favoriteDrinkRepository, cocktailApi, viewModelScope)

    fun addDrinkToFavorites() {
        val drink = drinkInfo.value
        drinkUtils.addFavoriteDrink(
            Drink(
                drink?.idDrink ?: "",
                drink?.strDrink ?: "",
                drink?.strDrinkThumb ?: ""
            )
        )
    }
}