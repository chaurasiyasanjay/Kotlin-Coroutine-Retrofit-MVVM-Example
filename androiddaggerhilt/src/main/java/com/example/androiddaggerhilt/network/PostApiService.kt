package com.example.androiddaggerhilt.network

import com.example.androiddaggerhilt.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getPost(): List<Post>

}