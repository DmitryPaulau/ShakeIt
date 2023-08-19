package com.example.shakeit.ui.allcocktails.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shakeit.databinding.ItemCocktailBinding
import com.example.shakeit.model.Drink

class CocktailsViewHolder(private val binding: ItemCocktailBinding): ViewHolder(binding.root) {

    fun bind(cocktail: Drink){
    binding.cocktail.text =  cocktail.strDrink
    }

}