package com.mak.tvshows.repo.usecase

import android.content.Context
import com.mak.tvshows.data.ApiResult
import com.mak.tvshows.repo.model.TrendingShowResponse
import com.mak.tvshows.repo.repository.ShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowUseCase @Inject constructor(
    private val context: Context,
    private val repository: ShowRepository
) {
    /**
     * This will get call from home screen
     */
    operator fun invoke(): Flow<ApiResult<TrendingShowResponse>> =
        flow {
            repository.getPopularShows().collect { result ->
                when (result) {
                    is ApiResult.Loading -> {
                        emit(ApiResult.Loading())
                    }

                    is ApiResult.Error -> {
                        emit(ApiResult.Error(result.error))
                    }

                    is ApiResult.Success -> {
                        emit(ApiResult.Success(result.data))
                    }
                }
            }
//            if (q.isNullOrBlank() || q.isEmpty()) {
//                emit(
//                    ApiResult.Error(
//                        ApiError(
//                            NetworkUtility.NetworkError.VALIDATION_ERROR.code,
//                            "Please enter search query"
//                        )
//                    )
//                )
//            } else {
//                repository.getPopularShows(token, q, page).collect { result ->
//                    when (result) {
//                        is ApiResult.Loading -> {
//                            emit(ApiResult.Loading())
//                        }
//
//                        is ApiResult.Error -> {
//                            emit(ApiResult.Error(result.error))
//                        }
//
//                        is ApiResult.Success -> {
//                            emit(ApiResult.Success(result.data))
//                        }
//                    }
//                }
//            }
        }
}