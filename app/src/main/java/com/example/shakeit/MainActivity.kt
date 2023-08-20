package com.example.shakeit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.shakeit.repository.SharedPreferenceRepository
import com.example.shakeit.ui.BottomNavigationFragment
import com.example.shakeit.ui.onboarding.OnboardingFragment
import com.example.shakeit.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        if (SharedPreferenceRepository.isFirstOpen()) {
            SharedPreferenceRepository.setIsFirstOpen(false)
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