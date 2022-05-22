package com.yago.architectcoders.ui.dayForecast.detail

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.yago.architectcoders.domain.Weather

class DetailDayForecastInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    fun setWeather(weather: Weather) = weather.apply {
        text = buildSpannedString {

            bold { append("Original id: ") }
            appendLine(date)

            bold { append("Original title: ") }
            appendLine(description)
        }
    }
}