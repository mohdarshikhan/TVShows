package com.mak.tvshows.ui.home.viewModel

import androidx.lifecycle.viewModelScope
import com.mak.tvshows.base.BaseViewModel
import com.mak.tvshows.data.ApiResult
import com.mak.tvshows.repo.model.ShowResults
import com.mak.tvshows.repo.usecase.ShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val showUseCase: ShowUseCase
) : BaseViewModel() {

    private val _TrendingShowResponse = MutableStateFlow<ArrayList<ShowResults>>(ArrayList())
    val trendingShowResponse = _TrendingShowResponse.asStateFlow()

    fun getPopularShows() {
        showUseCase().onEach { result ->
            when (result) {
                is ApiResult.Loading -> {
                    showProgressFlow.emit(true)
                }

                is ApiResult.Success -> {
                    hideProgressFlow.emit(true)
                    _TrendingShowResponse.emit(result.data.results)

                }

                is ApiResult.Error -> {
                    hideProgressFlow.emit(true)

                    errorFlow.emit(result.error.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}