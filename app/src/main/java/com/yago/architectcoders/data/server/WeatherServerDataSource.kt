package com.yago.architectcoders.data.server

import arrow.core.Either
import com.yago.architectcoders.data.datasource.WeatherRemoteDataSource
import com.yago.architectcoders.data.tryCall
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather

class WeatherServerDataSource(private val apiKey: String) : WeatherRemoteDataSource {

    override suspend fun findPopularWeather(
        latitude: Double,
        longitude: Double
    ): Either<Error, List<Weather>> = tryCall {
        RemoteConnection.service
            .listPopularWeathers(apiKey, latitude, longitude)
            .results
            .toDomainModel()
    }
}

private fun List<RemoteWeather>.toDomainModel(): List<Weather> = map { it.toDomainModel() }

private fun RemoteWeather.toDomainModel(): Weather =
    Weather(
        -1,
        weather?.code ?: -1,
        datetime ?: "nulo?",
        weather?.description ?: "descrip?",
        windDirection ?: "dirre1ç",
        clouds ?: -13,
        moonrise ?: -13,
        sunrise ?: -13,
        averageHumidity ?: -13,
        averagePressure ?: .13,
        minTemp ?: .13,
        maxTemp ?: .13,
        temp ?: .13,
        sunSet ?: -13,
        moonSet ?: -13,
        ozone ?: .13,
        windGustSpeed ?: -.13,
        snowDepth ?: -13,
        feelsMinTemp ?: -.13,
        feelsMaxTemp ?: -.13,
        windSpeed ?: -.13,
        precipitationPercentage ?: -13,
        seaLevePressure ?: -.13,
        visibilityKms ?: -.13,
        snow ?: -13,
        uv ?: -.13,
        precipitation ?: -.13,
        cloudsLow ?: -13,
        cloudsMid ?: -13,
        cloudsHi ?: -13
    )