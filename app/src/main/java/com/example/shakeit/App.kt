package com.example.shakeit

import android.app.Application
import com.example.shakeit.repository.SharedPreferenceRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceRepository.init(applicationContext)
    }
}