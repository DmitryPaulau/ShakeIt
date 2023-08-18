package com.example.shakeit.ui.allcocktails


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shakeit.model.Cocktail
import com.example.shakeit.repository.CocktailListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllCocktailsViewModel @Inject constructor(
    private val cocktailListRepository: CocktailListRepository
) : ViewModel() {

    val listCocktail = MutableLiveData<ArrayList<Cocktail>>()

//    fun getListCocktail() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = cocktailListRepository.getCocktailList()
//            if (response.isSuccessful) {
//                listCocktail.postValue()
//            }
//        }
//    }

}