package com.yago.architectcoders.ui.dayForecast.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yago.architectcoders.R
import com.yago.architectcoders.databinding.FragmentForecastListBinding
import com.yago.architectcoders.ui.common.launchAndCollect
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListDayForecastFragment : Fragment(R.layout.fragment_forecast_list) {

    private val viewModel: ListDayForecastViewModel by viewModel()

    private lateinit var mainState: MainState

    private val adapter = ListDayForecastsAdapter { mainState.onWeatherClicked(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainState = buildMainState()

        val binding = FragmentForecastListBinding.bind(view).apply {
            recycler.adapter = adapter
        }

        binding.apply {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
            toolbar.setOnClickListener {
                Log.d(
                    ListDayForecastFragment::class.java.name,
                    "setOnClickListener"
                )
            }
        }

        viewLifecycleOwner.launchAndCollect(viewModel.countryName) {
            binding.apply {
                toolbar.title = it
            }
        }

        viewLifecycleOwner.launchAndCollect(viewModel.state) {
            binding.apply {
                loading = it.loading
                weathers = it.weathers
                error = it.error?.let(mainState::errorToString)
            }
        }

        mainState.requestLocationPermission {
            viewModel.onUiReady()
        }
    }
}