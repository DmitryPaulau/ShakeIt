package com.example.shakeit.ui.allcocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.shakeit.databinding.ItemCocktailBinding
import com.example.shakeit.model.Drink

class CocktailsAdapter(
    private val onClick: (id: String) -> Unit
) : ListAdapter<Drink, CocktailsViewHolder>(
    object : DiffUtil.ItemCallback<Drink>() {
        override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
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
        holder.itemView.setOnClickListener {
            onClick(
                getItem(position).idDrink
            )
        }
    }
}


