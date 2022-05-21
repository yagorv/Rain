package com.yago.architectcoders.data.server

import com.google.gson.annotations.SerializedName

data class RemoteResult(
    @SerializedName("data") val results: List<RemoteWeather>,
    val timezone: String,
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("city_name") val cityName: String,
    @SerializedName("lon") val longitude: String,
    @SerializedName("lat") val latitude: String,
    @SerializedName("state_code") val stateCode: String
)

data class RemoteWeather(
    val datetime: String?,
    val weather: RemoteWeatherDescription?,
    @SerializedName("wind_cdir_full") val windDirection: String?,
    val clouds: Int?,
    @SerializedName("moonrise_ts") val moonrise: Long?,
    @SerializedName("sunrise_ts") val sunrise: Long?,
    @SerializedName("rh") val averageHumidity: Int?,
    @SerializedName("pres") val averagePressure: Double?,
    @SerializedName("min_temp") val minTemp: Double?,
    @SerializedName("max_temp") val maxTemp: Double?,
    val temp: Double?,
    @SerializedName("sunset_ts") val sunSet: Long?,
    @SerializedName("moonset_ts") val moonSet: Long?,
    val ozone: Double?,
    @SerializedName("wind_gust_spd") val windGustSpeed: Double?,
    @SerializedName("snow_depth") val snowDepth: Int?,
    @SerializedName("app_min_temp") val feelsMinTemp: Double?,
    @SerializedName("app_max_temp") val feelsMaxTemp: Double?,
    @SerializedName("wind_spd") val windSpeed: Double?,
    @SerializedName("pop") val precipitationPercentage: Int?,
    @SerializedName("slp") val seaLevePressure: Double?,
    @SerializedName("vis") val visibilityKms: Double?,
    val snow: Int?,
    val uv: Double?,
    @SerializedName("precip") val precipitation: Double?,
    @SerializedName("clouds_low") val cloudsLow: Int?,
    @SerializedName("clouds_mid") val cloudsMid: Int?,
    @SerializedName("clouds_hi") val cloudsHi: Int?
)

data class RemoteWeatherDescription(
    val icon: String?,
    val code: Int?,
    val description: String?,
)