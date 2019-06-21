package com.android.techflakepractical.domain.repository

import com.android.techflakepractical.data.VideosModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WebApi {
    @GET("search")
    fun searchGiphyVideos(@QueryMap param: HashMap<String, String>): Observable<VideosModel>
}