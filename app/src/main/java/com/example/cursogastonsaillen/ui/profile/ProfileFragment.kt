package com.example.cursogastonsaillen.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cursogastonsaillen.R
import com.example.cursogastonsaillen.databinding.FragmentMovieBinding
import com.example.cursogastonsaillen.databinding.FragmentProfileBinding
import com.example.cursogastonsaillen.presentation.ProfileViewModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by activityViewModels()

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.apply {
            txtLastMovieViewed.text = viewModel.getCurrentMovie().value
        }

        findNavController().previousBackStackEntry?.savedStateHandle?.set("movie", "MyMovie")

    }

}