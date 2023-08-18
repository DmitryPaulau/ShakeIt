package com.example.shakeit.ui.allcocktails.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shakeit.databinding.ItemCocktailBinding
import com.example.shakeit.model.Cocktail
import com.example.shakeit.model.network.Drink

class CocktailsViewHolder(private val binding: ItemCocktailBinding): ViewHolder(binding.root) {

    fun bind(cocktail: Cocktail){
    binding.cocktail.text =  cocktail.strDrink
    }

}