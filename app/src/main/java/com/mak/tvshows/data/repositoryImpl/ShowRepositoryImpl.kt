package com.mak.tvshows.data.repositoryImpl

import com.mak.tvshows.data.ApiResult
import com.mak.tvshows.data.remote.AppApis
import com.mak.tvshows.repo.model.TrendingShowResponse
import com.mak.tvshows.repo.repository.ShowRepository
import com.mak.tvshows.utils.NetworkUtility
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowRepositoryImpl @Inject constructor(
    private val networkUtility: NetworkUtility,
    private val appApis: AppApis
) : ShowRepository {

    override fun getPopularShows(): Flow<ApiResult<TrendingShowResponse>> =
        flow {
            networkUtility.safeApiCall { appApis.getPopularShows() }
                .collect { result -> emit(result) }
        }

}