package com.mak.tvshows.repo.model

import com.google.gson.annotations.SerializedName


data class TrendingShowResponse(

    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<ShowResults> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null

)