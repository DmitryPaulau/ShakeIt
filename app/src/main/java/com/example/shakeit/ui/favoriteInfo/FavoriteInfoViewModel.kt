package com.example.shakeit.ui.favoriteInfo

import androidx.lifecycle.ViewModel
import com.example.shakeit.network.CocktailApi
import com.example.shakeit.repository.FavoriteDrinkRepository
import javax.inject.Inject

class FavoriteInfoViewModel @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val favoriteDrinkRepository: FavoriteDrinkRepository
) : ViewModel() {

}