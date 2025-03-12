package com.sattech.countyapp.data.repository

import com.sattech.countyapp.data.mappper.Mapper.toDomain
import com.sattech.countyapp.data.network.ApiInterface
import com.sattech.countyapp.domain.model.Post
import com.sattech.countyapp.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface) :
    PostRepository {
    override suspend fun getPosts(): List<Post> {
        val response = apiInterface.getPosts().body() ?: emptyList()
        return response.map { it.toDomain() }
    }
}