package com.example.shakeit.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shakeit.model.Drink
import com.example.shakeit.repository.FavoriteDrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteDrinkViewModel @Inject constructor(
    private val favoriteDrinkRepository: FavoriteDrinkRepository
) : ViewModel() {

    val favoriteDrinks = MutableLiveData<List<Drink>>()

    fun loadFavoriteDrinks() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = favoriteDrinkRepository.getAllFavoriteDrinks()
            favoriteDrinks.postValue(
                response.map {
                    Drink(
                        it.idDrink,
                        it.strDrink ?: "",
                        it.strDrinkThumb ?: ""
                    )
                }
            )
        }
    }
}