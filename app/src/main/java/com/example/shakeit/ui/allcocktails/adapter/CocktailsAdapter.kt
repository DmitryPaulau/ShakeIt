package com.example.shakeit.ui.allcocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.shakeit.databinding.ItemCocktailBinding
import com.example.shakeit.model.Cocktail


class CocktailsAdapter : ListAdapter<Cocktail, CocktailsViewHolder>(
    object : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return false
        }

    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsViewHolder {
        return CocktailsViewHolder(
            ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CocktailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
