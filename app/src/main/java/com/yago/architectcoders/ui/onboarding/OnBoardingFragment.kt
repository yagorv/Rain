package com.yago.architectcoders.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.yago.architectcoders.R
import com.yago.architectcoders.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentOnBoardingBinding.bind(view)
        val navController: NavController = findNavController()
        binding.button16forecast.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnBoardingToMainDest()
            navController.navigate(action)
        }
    }
}