package com.yago.architectcoders.ui.dayForecast.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yago.architectcoders.R
import com.yago.architectcoders.databinding.FragmentForecastDetailBinding
import com.yago.architectcoders.ui.common.launchAndCollect
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailDayForecastFragment : Fragment(R.layout.fragment_forecast_detail) {

    private val safeArgs: DetailDayForecastFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by viewModel {
        parametersOf(safeArgs.weatherId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentForecastDetailBinding.bind(view)

        binding.apply {
            weatherDetailToolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
            weatherDetailFavorite.setOnClickListener {
                Log.d(
                    DetailDayForecastFragment::class.java.name,
                    "setOnClickListener"
                )
            }
        }

        viewLifecycleOwner.launchAndCollect(viewModel.state) { state ->
            if (state.weather != null) {
                binding.weather = state.weather
            }
        }
    }
}