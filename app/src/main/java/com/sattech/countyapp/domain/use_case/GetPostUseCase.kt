package com.sattech.countyapp.domain.use_case

import com.sattech.countyapp.data.network.Resource
import com.sattech.countyapp.domain.model.Post
import com.sattech.countyapp.domain.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetPostUseCase @Inject constructor(private val postRepository: PostRepository) {

    operator fun invoke(): Flow<Resource<List<Post>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = postRepository.getPosts()))

        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}