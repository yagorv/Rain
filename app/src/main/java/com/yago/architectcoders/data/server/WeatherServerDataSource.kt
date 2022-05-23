package com.yago.architectcoders.data.server

import arrow.core.Either
import com.yago.architectcoders.data.datasource.WeatherRemoteDataSource
import com.yago.architectcoders.data.tryCall
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather
import com.yago.architectcoders.domain.WeatherCode

class WeatherServerDataSource(private val apiKey: String, private val service: RemoteService) :
    WeatherRemoteDataSource {

    override suspend fun getForecastWeathers(
        latitude: Double,
        longitude: Double
    ): Either<Error, List<Weather>> = tryCall {
        service
            .listPopularWeathers(apiKey, latitude, longitude)
            .results
            .toDomainModel()
    }
}

private fun List<RemoteWeather>.toDomainModel(): List<Weather> = map { it.toDomainModel() }

private fun RemoteWeather.toDomainModel(): Weather =
    Weather(
        -1,
        WeatherCode.valueOf(weather?.code ?: -1),
        datetime ?: "",
        weather?.description ?: "",
        windDirection ?: "",
        clouds ?: -1,
        moonrise ?: -1,
        sunrise ?: -1,
        averageHumidity ?: -1,
        averagePressure ?: -.1,
        minTemp ?: -.1,
        maxTemp ?: -.1,
        temp ?: -.1,
        sunSet ?: -1,
        moonSet ?: -1,
        ozone ?: -.1,
        windGustSpeed ?: -.1,
        snowDepth ?: -1,
        feelsMinTemp ?: -.1,
        feelsMaxTemp ?: -.1,
        windSpeed ?: -.1,
        precipitationPercentage ?: -1,
        seaLevePressure ?: -.1,
        visibilityKms ?: -.1,
        snow ?: -1,
        uv ?: -.1,
        precipitation ?: -.1,
        cloudsLow ?: -1,
        cloudsMid ?: -1,
        cloudsHi ?: -1
    )