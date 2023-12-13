package com.mak.tvshows.di

import com.mak.tvshows.BuildConfig
import com.mak.tvshows.data.remote.AppApis
import com.mak.tvshows.utils.NetworkUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(networkUtility: NetworkUtility): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(networkUtility.getOkHttpClient())
            .build()

    @Singleton
    @Provides
    fun provideAppApi(retrofit: Retrofit): AppApis =
        retrofit.create(AppApis::class.java)
}