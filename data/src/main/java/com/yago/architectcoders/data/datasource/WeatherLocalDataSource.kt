package com.yago.architectcoders.data.datasource

import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherLocalDataSource {
    val weathers: Flow<List<Weather>>

    suspend fun isEmpty(): Boolean
    fun findById(id: Int): Flow<Weather>
    suspend fun save(weathers: List<Weather>): Error?
}