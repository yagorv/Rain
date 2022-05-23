package com.yago.architectcoders.ui.dayForecast.list

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yago.architectcoders.domain.Weather

@BindingAdapter("items")
fun RecyclerView.setItems(weathers: List<Weather>?) {
    if (weathers != null) {
        (adapter as? ListDayForecastsAdapter)?.submitList(weathers)
    }
}