package com.yago.architectcoders.ui.detail

import androidx.databinding.BindingAdapter
import com.yago.architectcoders.domain.Weather

@BindingAdapter("weather")
fun WeatherDetailInfoView.updateWeatherDetails(weather: Weather?) {
    if (weather != null) {
        setWeather(weather)
    }
}