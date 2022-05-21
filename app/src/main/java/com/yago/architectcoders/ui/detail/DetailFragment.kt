package com.yago.architectcoders.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yago.architectcoders.R
import com.yago.architectcoders.databinding.FragmentDetailBinding
import com.yago.architectcoders.ui.common.launchAndCollect
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val safeArgs: DetailFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by viewModel {
        parametersOf(safeArgs.weatherId)
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