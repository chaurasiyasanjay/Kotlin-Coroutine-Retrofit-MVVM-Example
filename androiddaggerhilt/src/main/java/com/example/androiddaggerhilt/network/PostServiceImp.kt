package com.example.androiddaggerhilt.network

import com.example.androiddaggerhilt.model.Post
import javax.inject.Inject

class PostServiceImp @Inject constructor(private val postApiService: PostApiService) {

    suspend fun getPost():List<Post> = postApiService.getPost()

}