package com.example.shakeit.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shakeit.R
import com.example.shakeit.databinding.FragmentOnboardingBinding
import com.example.shakeit.ui.allcocktails.AllCocktailsFragment
import com.example.shakeit.util.replaceFragment

class OnboardingFragment : Fragment() {

    private var binding: FragmentOnboardingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.openListFragment?.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, AllCocktailsFragment())
        }
        binding?.viewPager?.adapter = OnboardingAdapter(parentFragmentManager)
//        binding?.circleIndicator?.setViewPager(binding?.viewPager)

    }
}