package com.example.shakeit.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.shakeit.network.CocktailApi.Companion.BASE_URL

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideCocktailApi(): CocktailApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CocktailApi::class.java)
    }
}