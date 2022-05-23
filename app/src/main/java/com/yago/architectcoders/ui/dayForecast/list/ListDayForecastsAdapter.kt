package com.yago.architectcoders.ui.dayForecast.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yago.architectcoders.R
import com.yago.architectcoders.databinding.ViewWeatherBinding
import com.yago.architectcoders.domain.Weather
import com.yago.architectcoders.ui.common.basicDiffUtil
import com.yago.architectcoders.ui.common.inflate

class ListDayForecastsAdapter(private val listener: (Weather) -> Unit) :
    ListAdapter<Weather, ListDayForecastsAdapter.ViewHolder>(basicDiffUtil { old, new -> old.id == new.id }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_weather, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = getItem(position)
        holder.apply {
            bind(weather)
            itemView.setOnClickListener { listener(weather) }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewWeatherBinding.bind(view)
        fun bind(weather: Weather) {
            binding.weather = weather
        }
    }
}