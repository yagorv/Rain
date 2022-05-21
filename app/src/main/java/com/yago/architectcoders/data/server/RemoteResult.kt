package com.yago.architectcoders.data.server

import com.google.gson.annotations.SerializedName

data class RemoteResult(
    @SerializedName("data") val results: List<RemoteWeather>,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("country_code") val countryCode: String
)

data class RemoteWeather(
    val datetime: String?,
    val weather: RemoteWeatherDescription?,
    @SerializedName("wind_cdir_full") val windDirection: String?,
    val clouds: Int?
)

data class RemoteWeatherDescription(
    val description: String?,
)