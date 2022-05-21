package com.yago.architectcoders.data.server

import arrow.core.Either
import com.yago.architectcoders.data.datasource.WeatherRemoteDataSource
import com.yago.architectcoders.data.tryCall
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather

class WeatherServerDataSource(private val apiKey: String) : WeatherRemoteDataSource {

    override suspend fun findPopularWeather(): Either<Error, List<Weather>> = tryCall {
        RemoteConnection.service
            .listPopularWeathers(apiKey)
            .results
            .toDomainModel()
    }
}

private fun List<RemoteWeather>.toDomainModel(): List<Weather> = map { it.toDomainModel() }

private fun RemoteWeather.toDomainModel(): Weather =
    Weather(
        -1,
        "https://picsum.photos/200",
        datetime ?: "nulo?",
        weather?.description ?: "descrip?",
        windDirection ?: "dirre1ç",
        clouds ?: -13
    )