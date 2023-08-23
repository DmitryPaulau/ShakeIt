package com.example.shakeit.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shakeit.R
import com.example.shakeit.databinding.FragmentFavoritesBinding
import com.example.shakeit.model.Drink
import com.example.shakeit.ui.allcocktails.adapter.CocktailsAdapter
import com.example.shakeit.ui.cocktailInfo.CocktailInfoFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private var binding: FragmentFavoritesBinding? = null

    private val viewModel: FavoriteDrinkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.favoriteDrinks.observe(viewLifecycleOwner) {
            setList(it as ArrayList<Drink>)
        }
        viewModel.loadFavoriteDrinks()
    }

    private fun setList(list: ArrayList<Drink>) {
        binding?.recyclerViewFavorites?.run {
            if (adapter == null) {
                adapter = CocktailsAdapter {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.bottomNavigationContainer, CocktailInfoFragment().apply {
                            arguments = bundleOf("ID" to it)
                        }).addToBackStack(it)
                        .commit()
                }
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
            (adapter as? CocktailsAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }

}