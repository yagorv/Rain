package com.yago.architectcoders.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbWeather(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val imageCode: Int,
    val date: String,
    val description: String,
    val windDirection: String,
    val clouds: Int,
    val moonrise: Long,
    val sunrise: Long,
    val averageHumidity: Int,
    val averagePressure: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val temp: Double,
    val sunSet: Long,
    val moonSet: Long,
    val ozone: Double,
    val windGustSpeed: Double,
    val snowDepth: Int,
    val feelsMinTemp: Double,
    val feelsMaxTemp: Double,
    val windSpeed: Double,
    val precipitationPercentage: Int,
    val seaLevePressure: Double,
    val visibilityKms: Double,
    val snow: Int,
    val uv: Double,
    val precipitation: Double,
    val cloudsLow: Int,
    val cloudsMid: Int,
    val cloudsHi: Int,
)