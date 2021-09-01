package com.example.androiddaggerhilt.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.androiddaggerhilt.Repository.PostRepository
import com.example.androiddaggerhilt.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) :
    ViewModel() {

    val response: LiveData<List<Post>> = postRepository.getPost()
        .catch { e -> Log.e("main", "${e.message}") }.asLiveData()

}