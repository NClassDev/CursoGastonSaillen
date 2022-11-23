package com.example.cursogastonsaillen.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.cursogastonsaillen.R
import com.example.cursogastonsaillen.databinding.FragmentMovieDatailBinding


class MovieDatailFragment : Fragment(R.layout.fragment_movie_datail) {

    private lateinit var binding : FragmentMovieDatailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDatailBinding.bind(view)
    }

}