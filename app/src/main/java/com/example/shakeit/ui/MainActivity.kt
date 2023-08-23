package com.example.shakeit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.shakeit.R
import com.example.shakeit.repository.SharedPreferenceRepository
import com.example.shakeit.ui.onboarding.OnboardingFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        if (sharedPreferenceRepository.isFirstOpen()) {
            sharedPreferenceRepository.setIsFirstOpen(false)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, OnboardingFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BottomNavigationFragment())
                .commit()
        }
    }
}