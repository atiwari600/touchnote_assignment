package com.sattech.countyapp.presentaion.posts

import com.sattech.countyapp.domain.model.Post

data class PostState(
    val isLoading: Boolean = false,
    val error: String = "",
    val posts: List<Post>? = null
)