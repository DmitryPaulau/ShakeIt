package com.example.shakeit.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.shakeit.databinding.ItemCocktailFavoritesBinding
import com.example.shakeit.model.Drink

class FavoriteDrinkAdapter(
    private val onClick: (id: String) -> Unit
) : ListAdapter<Drink, FavoriteDrinkViewHolder>(
    object : DiffUtil.ItemCallback<Drink>() {
        override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return false
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDrinkViewHolder {
        return FavoriteDrinkViewHolder(
            ItemCocktailFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteDrinkViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClick(
                getItem(position).idDrink
            )
        }
    }
}