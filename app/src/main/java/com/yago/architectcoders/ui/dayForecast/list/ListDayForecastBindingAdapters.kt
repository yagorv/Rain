package com.yago.architectcoders.ui.dayForecast

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yago.architectcoders.domain.Weather
import com.yago.architectcoders.ui.dayForecast.list.WeathersAdapter

@BindingAdapter("items")
fun RecyclerView.setItems(weathers: List<Weather>?) {
    if (weathers != null) {
        (adapter as? WeathersAdapter)?.submitList(weathers)
    }
}