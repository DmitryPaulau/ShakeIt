package com.example.shakeit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.shakeit.R
import com.example.shakeit.repository.CocktailListRepository
import com.example.shakeit.ui.onboarding.OnboardingFragment
import com.example.shakeit.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cocktailListRepository: CocktailListRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .replaceFragment(R.id.container, OnboardingFragment())

    }
}