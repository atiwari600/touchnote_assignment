package com.sattech.countyapp.domain.repository

import com.sattech.countyapp.domain.model.Post

interface PostRepository {

    suspend fun getPosts(): List<Post>
}