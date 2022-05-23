package com.yago.architectcoders.data.datasource

import arrow.core.Either
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather

interface WeatherRemoteDataSource {
    suspend fun getForecastWeathers(
        latitude: Double,
        longitude: Double
    ): Either<Error, List<Weather>>
}