package com.yago.architectcoders.ui.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.yago.architectcoders.R
import com.yago.architectcoders.domain.WeatherCode

@BindingAdapter("url")
fun ImageView.bindUrl(url: String?) {
    if (url != null) loadUrl(url)
}

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("weatherCode")
fun ImageView.bindImage(weatherCode: WeatherCode?) {
    when (weatherCode) {
        WeatherCode.BrokenClouds -> setImageResource(R.drawable.wi_cloudy)
        WeatherCode.ClearSky -> setImageResource(R.drawable.wi_day_sunny)
        WeatherCode.Drizzle -> setImageResource(R.drawable.wi_sleet)
        WeatherCode.FewClouds -> setImageResource(R.drawable.wi_day_cloudy)
        WeatherCode.Flurries -> setImageResource(R.drawable.wi_snow)
        WeatherCode.Fog -> setImageResource(R.drawable.wi_day_fog)
        WeatherCode.FreezingFog -> setImageResource(R.drawable.wi_day_fog)
        WeatherCode.FreezingRain -> setImageResource(R.drawable.wi_rain)
        WeatherCode.Haze -> setImageResource(R.drawable.wi_day_fog)
        WeatherCode.HeavyDrizzle -> setImageResource(R.drawable.wi_rain_mix)
        WeatherCode.HeavyRain -> setImageResource(R.drawable.wi_rain)
        WeatherCode.HeavyShowerRain -> setImageResource(R.drawable.wi_day_showers)
        WeatherCode.HeavySleet -> setImageResource(R.drawable.wi_cloudy_gusts)
        WeatherCode.HeavySnow -> setImageResource(R.drawable.wi_snow)
        WeatherCode.HeavySnowShower -> setImageResource(R.drawable.wi_snow_wind)
        WeatherCode.LightDrizzle -> setImageResource(R.drawable.wi_day_rain_mix)
        WeatherCode.LightRain -> setImageResource(R.drawable.wi_day_rain_mix)
        WeatherCode.LightShowerRain -> setImageResource(R.drawable.wi_day_rain_mix)
        WeatherCode.LightSnow -> setImageResource(R.drawable.wi_day_snow)
        WeatherCode.Mist -> setImageResource(R.drawable.wi_day_cloudy_windy)
        WeatherCode.MixSnowRain -> setImageResource(R.drawable.wi_day_snow)
        WeatherCode.ModerateRain -> setImageResource(R.drawable.wi_rain)
        WeatherCode.OvercastClouds -> setImageResource(R.drawable.wi_cloudy)
        WeatherCode.SandDust -> setImageResource(R.drawable.wi_day_cloudy_windy)
        WeatherCode.ScatteredClouds -> setImageResource(R.drawable.wi_day_cloudy)
        WeatherCode.ShowerRain -> setImageResource(R.drawable.wi_day_showers)
        WeatherCode.Sleet -> setImageResource(R.drawable.wi_cloudy_gusts)
        WeatherCode.Smoke -> setImageResource(R.drawable.wi_day_cloudy_gusts)
        WeatherCode.Snow -> setImageResource(R.drawable.wi_snow)
        WeatherCode.SnowShower -> setImageResource(R.drawable.wi_day_snow_wind)
        WeatherCode.ThunderStormWithDrizzle -> setImageResource(R.drawable.wi_day_snow_thunderstorm)
        WeatherCode.ThunderStormWithHail -> setImageResource(R.drawable.wi_lightning)
        WeatherCode.ThunderStormWithHeavyDrizzle -> setImageResource(R.drawable.wi_thunderstorm)
        WeatherCode.ThunderStormWithHeavyRain -> setImageResource(R.drawable.wi_thunderstorm)
        WeatherCode.ThunderStormWithLightDrizzle -> setImageResource(R.drawable.wi_day_thunderstorm)
        WeatherCode.ThunderStormWithLightRain -> setImageResource(R.drawable.wi_day_thunderstorm)
        WeatherCode.ThunderStormWithRain -> setImageResource(R.drawable.wi_thunderstorm)
        WeatherCode.UnknownPrecipitation -> setImageResource(R.drawable.wi_day_rain_wind)
        else -> setImageResource(R.drawable.wi_day_rain_wind)
    }
}