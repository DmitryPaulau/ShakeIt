package com.example.shakeit.repository

import com.example.shakeit.db.FavoriteDrinkDao
import com.example.shakeit.model.DrinkDetailsEntity
import javax.inject.Inject


class FavoriteDrinkRepository @Inject constructor(
    private val favoriteDrinkDao: FavoriteDrinkDao
) {

    suspend fun addMyFavoriteDrinks(drink: DrinkDetailsEntity) {
        favoriteDrinkDao.addFavoriteDrink(drink)
    }

    suspend fun getAllFavoriteDrinks(): List<DrinkDetailsEntity> {
        return favoriteDrinkDao.getAllFavoriteDrinks()
    }

    suspend fun deleteFavoriteDrink(drink: DrinkDetailsEntity) {
        favoriteDrinkDao.deleteFavoriteDrink(drink)
    }
}

