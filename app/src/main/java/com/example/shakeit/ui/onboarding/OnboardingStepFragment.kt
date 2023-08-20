package com.example.shakeit.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.shakeit.R
import com.example.shakeit.databinding.FragmentOnboardingStepBinding

const val STEP_1 = 1
const val STEP_2 = 2
const val STEP_3 = 3

private const val STEP_EXTRA = "stepExtra"

class OnboardingStepFragment : Fragment() {

    private var binding: FragmentOnboardingStepBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingStepBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val step = arguments?.getInt(STEP_EXTRA) ?: STEP_1

        when (step) {
            STEP_1 -> {
                binding?.imageOnboardingStep?.setImageResource(R.drawable.onboarding)
                binding?.textOnboardingStep?.setText(R.string.onboarding_step1_text)
            }

            STEP_2 -> {
                binding?.imageOnboardingStep?.setImageResource(R.drawable.onboarding1)
                binding?.textOnboardingStep?.setText(R.string.onboarding_step2_text)
            }

            STEP_3 -> {
                binding?.imageOnboardingStep?.setImageResource(R.drawable.onboarding2)
                binding?.textOnboardingStep?.setText(R.string.onboarding_step3_text)
            }
        }
    }

    companion object {
        fun getOnboardingStepFragment(stepNumber: Int): OnboardingStepFragment {
            return OnboardingStepFragment().apply {
                arguments = bundleOf(STEP_EXTRA to stepNumber)
            }
        }
    }
}

