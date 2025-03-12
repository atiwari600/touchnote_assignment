package com.sattech.countyapp.data.network

import com.sattech.countyapp.data.model.ResponseDtoItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/posts")
    suspend fun getPosts(): Response<List<ResponseDtoItem>>

}