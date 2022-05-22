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
    val popularWeathers = localDataSource.weathers

    fun findById(id: Int): Flow<Weather> = localDataSource.findById(id)

    suspend fun requestPopularWeathers(): Error? {
        if (localDataSource.isEmpty()) {
            val location = locationDataSource.findLastLocation()
            val latitude = location?.first ?: 0.00
            val longitude = location?.second ?: 0.00
            val weathers = remoteDataSource.findPopularWeather(latitude, longitude)
            weathers.fold(ifLeft = {
                return it
            }) {
                localDataSource.save(it)
            }
        }
        return null
    }
}