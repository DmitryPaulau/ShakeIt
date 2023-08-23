package com.example.shakeit.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.shakeit.databinding.FragmentRandomCocktailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomCocktailFragment : Fragment() {

    private var binding: FragmentRandomCocktailBinding? = null

    private val viewModel: RandomCocktailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomCocktailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.randomCocktail.observe(viewLifecycleOwner) {
            binding?.nameCocktailRandom?.text = it.strDrink
            binding?.categoryCocktail?.text = it.strAlcoholic
            binding?.instructions?.text = it.strInstructions
            binding?.ingredient1?.text = it.strIngredient1
            binding?.ingredient2?.text = it.strIngredient2
            binding?.ingredient3?.text = it.strIngredient3
            binding?.ingredient4?.text = it.strIngredient4
            binding?.ingredient5?.text = it.strIngredient5
            binding?.ingredient6?.text = it.strIngredient6
            binding?.ingredient7?.text = it.strIngredient7
            binding?.ingredient8?.text = it.strIngredient8
            binding?.measure1?.text = it.strMeasure1
            binding?.measure2?.text = it.strMeasure2
            binding?.measure3?.text = it.strMeasure3
            binding?.measure4?.text = it.strMeasure4
            binding?.measure5?.text = it.strMeasure5
            binding?.measure6?.text = it.strMeasure6
            binding?.measure7?.text = it.strMeasure7
            binding?.measure8?.text = it.strMeasure8

            binding?.imageViewInfo?.visibility = View.VISIBLE
            binding?.imageViewInfo?.let { it1 ->
                Glide
                    .with(requireContext())
                    .load(it.strDrinkThumb)
                    .into(it1)
            }
        }
        viewModel.getRandomCocktail()
    }
}
