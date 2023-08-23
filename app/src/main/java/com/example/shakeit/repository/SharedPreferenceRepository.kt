package com.example.shakeit.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val SHARED_PREF_FILE = "sharedPrefFile"
private const val IS_FIRST_OPEN = "isFirstOpen"

@Singleton
class SharedPreferenceRepository @Inject constructor(
    @ApplicationContext context: Context
) {
    private var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)

    }

    fun setIsFirstOpen(isFirstOpen: Boolean) {
        sharedPreferences.edit {
            putBoolean(IS_FIRST_OPEN, isFirstOpen)
        }
    }

    fun isFirstOpen(): Boolean {
        return sharedPreferences.getBoolean(IS_FIRST_OPEN, true)
    }
}