package com.yago.architectcoders.data.datasource

interface LocationDataSource {
    suspend fun findLastLocation(): Pair<Double, Double>?
}