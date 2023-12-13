package com.mak.tvshows.di

import com.mak.tvshows.data.remote.AppApis
import com.mak.tvshows.data.repositoryImpl.ShowRepositoryImpl
import com.mak.tvshows.repo.repository.ShowRepository
import com.mak.tvshows.utils.NetworkUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModules {

    @Singleton
    @Provides
    fun provideAuthRepository(networkUtility: NetworkUtility, appApis: AppApis): ShowRepository =
        ShowRepositoryImpl(networkUtility, appApis)
}