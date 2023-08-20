package com.example.shakeit.ui.allcocktails


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shakeit.model.Drink
import com.example.shakeit.repository.CocktailListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCocktailsViewModel @Inject constructor(
    private val cocktailListRepository: CocktailListRepository
) : ViewModel() {
    val listCocktail = MutableLiveData<ArrayList<Drink>>()

    fun getListCocktail() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = cocktailListRepository.getAllCocktailList()
            if (response.isSuccessful) {
            listCocktail.postValue(response.body()?.drinks)
            }
        }
    }
}