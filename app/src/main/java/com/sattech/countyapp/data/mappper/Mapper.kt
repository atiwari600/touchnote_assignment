package com.sattech.countyapp.data.mappper

import com.sattech.countyapp.data.model.ResponseDtoItem
import com.sattech.countyapp.domain.model.Post

object Mapper {

    fun ResponseDtoItem.toDomain(): Post {
        return Post(body, id, title, user_id)
    }
}