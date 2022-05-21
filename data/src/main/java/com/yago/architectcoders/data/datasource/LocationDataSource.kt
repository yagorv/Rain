package com.yago.architectcoders.data.datasource

interface LocationDataSource {
    suspend fun findLastRegion(): String?
}