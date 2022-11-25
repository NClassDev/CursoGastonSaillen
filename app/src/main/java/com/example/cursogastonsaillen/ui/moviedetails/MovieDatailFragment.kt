package com.example.cursogastonsaillen.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.cursogastonsaillen.R
import com.example.cursogastonsaillen.databinding.FragmentMovieDatailBinding
import com.example.cursogastonsaillen.presentation.MovieViewModel


class MovieDatailFragment : Fragment(R.layout.fragment_movie_datail) {

    private lateinit var binding : FragmentMovieDatailBinding

    private val args by navArgs<MovieDatailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDatailBinding.bind(view)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.posterImageUrl}").centerCrop().into(binding.imgMovie)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.backgroundImageUrl}").centerCrop().into(binding.imgBackground)

        binding.apply {
            txtLanguaje.text = args.languaje
            txtDescription.text = args.overview
            txtReleased.text = args.releaseDate
            txtDescription.text = args.overview
            txtRating.text = args.voteAverage
        }

    }

}