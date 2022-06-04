package com.yago.architectcoders.data

import com.yago.architectcoders.data.datasource.LocationDataSource
import com.yago.architectcoders.data.datasource.WeatherLocalDataSource
import com.yago.architectcoders.data.datasource.WeatherRemoteDataSource
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather
import kotlinx.coroutines.flow.Flow

class WeathersRepository(
    private val locationDataSource: LocationDataSource,
    private val localDataSource: WeatherLocalDataSource,
    private val remoteDataSource: WeatherRemoteDataSource
) {
    val forecastWeathers = localDataSource.weathers

    fun findById(id: Int): Flow<Weather> = localDataSource.findById(id)

    suspend fun requestForecastWeather(): Error? {
        if (localDataSource.isEmpty()) {
            locationDataSource.findLastLocation()?.apply {
                val weathers = remoteDataSource.getForecastWeathers(first, second)
                weathers.fold(ifLeft = {
                    return it
                }) {
                    localDataSource.save(it)
                }
            }
        }
        return null
    }
}