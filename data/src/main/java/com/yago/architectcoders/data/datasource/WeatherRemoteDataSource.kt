package com.yago.architectcoders.data.datasource

import arrow.core.Either
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather

interface WeatherRemoteDataSource {
    suspend fun findPopularWeather(): Either<Error, List<Weather>>
}