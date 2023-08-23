package com.example.shakeit.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shakeit.model.DrinkDetailsEntity

@Database (entities = [DrinkDetailsEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun favoriteDrinkDao(): FavoriteDrinkDao
}