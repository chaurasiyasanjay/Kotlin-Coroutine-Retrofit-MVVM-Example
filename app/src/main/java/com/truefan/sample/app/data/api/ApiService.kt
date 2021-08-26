package com.truefan.sample.app.data.api

import com.truefan.sample.app.data.model.Response
import retrofit2.http.GET

interface ApiService {

    @GET("response")
    suspend fun getData(): Response

}