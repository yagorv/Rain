package com.yago.architectcoders.data.database

import com.yago.architectcoders.data.datasource.WeatherLocalDataSource
import com.yago.architectcoders.data.tryCall
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather
import com.yago.architectcoders.domain.WeatherCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRoomDataSource(private val weatherDao: WeatherDao) : WeatherLocalDataSource {

    override val weathers: Flow<List<Weather>> = weatherDao.getAll().map { it.toDomainModel() }

    override suspend fun isEmpty(): Boolean = weatherDao.weatherCount() == 0

    override fun findById(id: Int): Flow<Weather> =
        weatherDao.findById(id).map { it.toDomainModel() }

    override suspend fun save(weathers: List<Weather>): Error? = tryCall {
        weatherDao.insertWeathers(weathers.fromDomainModel())
    }.fold(
        ifLeft = { it },
        ifRight = { null }
    )
}

private fun List<DbWeather>.toDomainModel(): List<Weather> =
    map { it.toDomainModel() }

private fun DbWeather.toDomainModel(): Weather =
    Weather(
        id ?: -1,
        WeatherCode.valueOf(weatherCode),
        date,
        description,
        windDirection,
        clouds,
        moonrise,
        sunrise,
        averageHumidity,
        averagePressure,
        minTemp,
        maxTemp,
        temp,
        sunSet,
        moonSet,
        ozone,
        windGustSpeed,
        snowDepth,
        feelsMinTemp,
        feelsMaxTemp,
        windSpeed,
        precipitationPercentage,
        seaLevePressure,
        visibilityKms,
        snow,
        uv,
        precipitation,
        cloudsLow,
        cloudsMid,
        cloudsHi
    )

private fun List<Weather>.fromDomainModel(): List<DbWeather> = map { it.fromDomainModel() }

private fun Weather.fromDomainModel(): DbWeather = DbWeather(
    id = null,
    WeatherCode.valueOf(weatherCode),
    date,
    description,
    windDirection,
    clouds,
    moonrise,
    sunrise,
    averageHumidity,
    averagePressure,
    minTemp,
    maxTemp,
    temp,
    sunSet,
    moonSet,
    ozone,
    windGustSpeed,
    snowDepth,
    feelsMinTemp,
    feelsMaxTemp,
    windSpeed,
    precipitationPercentage,
    seaLevePressure,
    visibilityKms,
    snow,
    uv,
    precipitation,
    cloudsLow,
    cloudsMid,
    cloudsHi
)