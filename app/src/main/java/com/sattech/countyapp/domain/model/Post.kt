package com.sattech.countyapp.domain.model

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int
)