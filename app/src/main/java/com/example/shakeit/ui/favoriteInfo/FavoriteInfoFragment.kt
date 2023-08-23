package com.example.shakeit.ui.favoriteInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.example.shakeit.databinding.FragmentFavoriteInfoBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteInfoFragment : Fragment() {

    private var binding: FragmentFavoriteInfoBinding? = null

    private val viewModel: FavoriteInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}