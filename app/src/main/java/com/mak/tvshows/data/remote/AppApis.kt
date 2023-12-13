package com.mak.tvshows.data.remote

import com.mak.tvshows.repo.model.TrendingShowResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApis {

    // https://api.themoviedb.org/3/trending/tv/week?language=en-US
    @GET("trending/tv/{time_window}")
    suspend fun getPopularShows(
        @Path("time_window") timeWindow: String = "week",
        @Query("language") language: String = "en-US"
    ): TrendingShowResponse
}