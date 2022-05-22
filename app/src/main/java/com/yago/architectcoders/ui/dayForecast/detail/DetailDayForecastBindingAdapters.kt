package com.yago.architectcoders.ui.dayForecast.detail

import androidx.databinding.BindingAdapter
import com.yago.architectcoders.domain.Weather

@BindingAdapter("weather")
fun DetailDayForecastInfoView.updateWeatherDetails(weather: Weather?) {
    if (weather != null) {
        setWeather(weather)
    }
}