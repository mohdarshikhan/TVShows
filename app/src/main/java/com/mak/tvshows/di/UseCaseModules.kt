package com.mak.tvshows.di

import android.content.Context
import com.mak.tvshows.repo.repository.ShowRepository
import com.mak.tvshows.repo.usecase.ShowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModules {

    @Singleton
    @Provides
    fun provideAuthUseCase(
        @ApplicationContext applicationContext: Context,
        showRepository: ShowRepository
    ) = ShowUseCase(applicationContext, showRepository)
}