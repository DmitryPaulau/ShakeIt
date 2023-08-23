package com.example.shakeit.ui.favorites.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.shakeit.databinding.ItemCocktailFavoritesBinding
import com.example.shakeit.model.Drink

class FavoriteDrinkViewHolder(
    private val binding: ItemCocktailFavoritesBinding
) : ViewHolder(binding.root) {

    fun bind(cocktail: Drink) {
        binding.cocktailFavorite.text = cocktail.strDrink

        Glide
            .with(itemView.context)
            .load(cocktail.strDrinkThumb)
            .into(binding.imageViewFavorite)
    }
}