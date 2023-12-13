package com.mak.tvshows.repo.repository

import com.mak.tvshows.data.ApiResult
import com.mak.tvshows.repo.model.TrendingShowResponse
import kotlinx.coroutines.flow.Flow

interface ShowRepository {
    fun getPopularShows(): Flow<ApiResult<TrendingShowResponse>>

}