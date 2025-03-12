package com.sattech.countyapp.presentaion.posts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sattech.countyapp.data.network.Resource
import com.sattech.countyapp.domain.use_case.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostUseCase: GetPostUseCase) : ViewModel() {
    private val _posts = mutableStateOf(PostState())
    val posts = _posts

    init {
        getPostsList()
    }

    fun getPostsList() {
        getPostUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _posts.value = PostState(isLoading = true)
                }

                is Resource.Success -> {
                    _posts.value = PostState(posts = it.data)
                }

                is Resource.Error -> {
                    _posts.value = PostState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}