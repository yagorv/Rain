package com.yago.architectcoders.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yago.architectcoders.R
import com.yago.architectcoders.data.WeathersRepository
import com.yago.architectcoders.data.database.WeatherRoomDataSource
import com.yago.architectcoders.data.server.WeatherServerDataSource
import com.yago.architectcoders.databinding.FragmentDetailBinding
import com.yago.architectcoders.ui.common.app
import com.yago.architectcoders.ui.common.launchAndCollect
import com.yago.architectcoders.usecases.FindWeatherUseCase

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val safeArgs: DetailFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by viewModels {
        val application = requireActivity().app
        val repository = WeathersRepository(
            WeatherRoomDataSource(application.db.weatherDao()),
            WeatherServerDataSource(getString(R.string.api_key))
        )
        DetailViewModelFactory(
            safeArgs.weatherId,
            FindWeatherUseCase(repository)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        binding.weatherDetailToolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
        binding.weatherDetailFavorite.setOnClickListener {
            Log.d(
                DetailFragment::class.java.name,
                "setOnClickListener"
            )
        }

        viewLifecycleOwner.launchAndCollect(viewModel.state) { state ->
            if (state.weather != null) {
                binding.weather = state.weather
            }
        }
    }
}