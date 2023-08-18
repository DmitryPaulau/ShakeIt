package com.example.shakeit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shakeit.R
import com.example.shakeit.databinding.FragmentBottomNavigationBinding
import com.example.shakeit.ui.allcocktails.AllCocktailsFragment
import com.example.shakeit.ui.favorites.FavoritesFragment
import com.example.shakeit.ui.random.RandomFragment

class BottomNavigationFragment : Fragment() {
    private var binding: FragmentBottomNavigationBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomNavigationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottomNavigationView?.selectedItemId = R.id.favorites
        binding?.bottomNavigationView?.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.all -> replaceFragment(AllCocktailsFragment())
                R.id.favorites -> replaceFragment(FavoritesFragment())
                R.id.random -> replaceFragment(RandomFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bottomNavigationContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}