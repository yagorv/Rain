package com.yago.architectcoders.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yago.architectcoders.R
import com.yago.architectcoders.data.WeathersRepository
import com.yago.architectcoders.data.database.WeatherRoomDataSource
import com.yago.architectcoders.data.server.WeatherServerDataSource
import com.yago.architectcoders.databinding.FragmentMainBinding
import com.yago.architectcoders.ui.common.app
import com.yago.architectcoders.ui.common.launchAndCollect
import com.yago.architectcoders.usecases.GetPopularWeathersUseCase
import com.yago.architectcoders.usecases.RequestPopularWeathersUseCase

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels {
        val application = requireActivity().app
        val repository = WeathersRepository(
            WeatherRoomDataSource(application.db.weatherDao()),
            WeatherServerDataSource(getString(R.string.api_key))
        )
        MainViewModelFactory(
            GetPopularWeathersUseCase(repository),
            RequestPopularWeathersUseCase(repository)
        )
    }

    private lateinit var mainState: MainState

    private val adapter = WeathersAdapter { mainState.onWeatherClicked(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainState = buildMainState()

        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }

        viewLifecycleOwner.launchAndCollect(viewModel.state) {
            binding.loading = it.loading
            binding.weathers = it.weathers
            binding.error = it.error?.let(mainState::errorToString)
        }

        mainState.requestLocationPermission {
            viewModel.onUiReady()
        }
    }
}