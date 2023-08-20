package com.example.shakeit.ui.allcocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.shakeit.databinding.FragmentAllCocktailsBinding
import com.example.shakeit.model.Drink
import com.example.shakeit.ui.allcocktails.adapter.CocktailsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllCocktailsFragment : Fragment() {

    private var binding: FragmentAllCocktailsBinding? = null

    private val viewModel: AllCocktailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllCocktailsBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listCocktail.observe(viewLifecycleOwner) {
            setList(it)
        }
        viewModel.getListCocktail()
    }

    private fun setList(list: ArrayList<Drink>) {
        binding?.recyclerView?.run {
            if (adapter == null) {
                adapter = CocktailsAdapter()
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
            (adapter as? CocktailsAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }
}

