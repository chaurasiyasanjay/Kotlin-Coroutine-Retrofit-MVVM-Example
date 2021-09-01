package com.retrofit.coroutine.mvvm.data.api

import com.retrofit.coroutine.mvvm.data.model.Response
import retrofit2.http.GET

interface ApiService {

    @GET("response")
    suspend fun getData(): Response

}