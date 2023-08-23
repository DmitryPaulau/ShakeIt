package com.example.shakeit.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.shakeit.ui.onboarding.OnboardingStepFragment.Companion.getOnboardingStepFragment

class OnboardingAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val listFragment =
        arrayListOf(
            getOnboardingStepFragment(STEP_1),
            getOnboardingStepFragment(STEP_2),
            getOnboardingStepFragment(STEP_3)
        )

    override fun getCount() = listFragment.size

    override fun getItem(position: Int): Fragment = listFragment[position]
}